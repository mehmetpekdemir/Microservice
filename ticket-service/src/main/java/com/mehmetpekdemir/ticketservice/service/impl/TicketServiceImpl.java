package com.mehmetpekdemir.ticketservice.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.commonservice.client.AccountServiceClient;
import com.mehmetpekdemir.commonservice.client.contract.AccountViewDTO;
import com.mehmetpekdemir.ticketservice.dto.TicketDTO;
import com.mehmetpekdemir.ticketservice.entity.PriorityType;
import com.mehmetpekdemir.ticketservice.entity.Ticket;
import com.mehmetpekdemir.ticketservice.entity.TicketStatus;
import com.mehmetpekdemir.ticketservice.entity.elasticsearch.TicketES;
import com.mehmetpekdemir.ticketservice.repository.TicketElasticSearchRepository;
import com.mehmetpekdemir.ticketservice.repository.TicketRepository;
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

	private final TicketElasticSearchRepository ticketElasticSearchRepository;

	private final AccountServiceClient accountServiceClient;

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

		ticketElasticSearchRepository.save(model);

		ticketDTO.setId(ticket.getId());
		return ticketDTO;
	}

}
