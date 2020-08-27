package com.mehmetpekdemir.ticketservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.commonservice.AccountServiceClient;
import com.mehmetpekdemir.commonservice.dto.AccountViewDTO;

import com.mehmetpekdemir.ticketservice.dto.TicketDTO;
import com.mehmetpekdemir.ticketservice.entity.PriorityType;
import com.mehmetpekdemir.ticketservice.entity.Ticket;
import com.mehmetpekdemir.ticketservice.entity.TicketStatus;
import com.mehmetpekdemir.ticketservice.entity.elasticsearch.TicketES;
import com.mehmetpekdemir.ticketservice.repository.TicketRepository;
import com.mehmetpekdemir.ticketservice.repository.elasticsearch.TicketESRepository;
import com.mehmetpekdemir.ticketservice.service.TicketService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor // Constructor Injection with lombok
public class TicketServiceImpl implements TicketService {

	private final TicketRepository ticketRepository;

	private final TicketESRepository ticketElasticRepository;

	private final ModelMapper modelMapper;

	private final AccountServiceClient accountServiceClient;

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public TicketDTO getTicketById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Page<TicketDTO> paginationForTickets(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public TicketDTO createTicket(TicketDTO ticketDTO) {
		Ticket ticket = new Ticket();

		final ResponseEntity<AccountViewDTO> accountViewDTO = accountServiceClient
				.getAccountById(ticketDTO.getAssignee());

		ticket.setDescription(ticketDTO.getDescription());
		ticket.setNotes(ticketDTO.getNotes());
		ticket.setAssignee(accountViewDTO.getBody().getId());
		ticket.setTicketDate(ticketDTO.getTicketDate());
		ticket.setTicketStatus(TicketStatus.valueOf(ticketDTO.getTicketStatus()));
		ticket.setPriorityType(PriorityType.valueOf(ticketDTO.getPriorityType()));

		ticket = ticketRepository.save(ticket);

		final TicketES model = TicketES.builder().id(ticket.getId()).description(ticket.getDescription())
				.notes(ticket.getNotes()).assignee(accountViewDTO.getBody().getFirstNameAndLastName())
				.priorityType(ticket.getPriorityType().getLabel()).ticketStatus(ticket.getTicketStatus().getLabel())
				.ticketDate(ticket.getTicketDate()).build();

		ticketElasticRepository.save(model);

		ticketDTO.setId(ticket.getId());
		return ticketDTO;
	}

	@Transactional
	@Override
	public TicketDTO updateTicket(String id, TicketDTO ticketDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
