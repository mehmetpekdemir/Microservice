package com.mehmetpekdemir.ticketservice.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.ticketservice.dto.TicketDTO;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public TicketDTO updateTicket(String id, TicketDTO ticketDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
