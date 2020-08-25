package com.mehmetpekdemir.ticketservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mehmetpekdemir.ticketservice.dto.TicketDTO;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface TicketService {

	TicketDTO getTicketById(String id);

	Page<TicketDTO> paginationForTickets(Pageable pageable);

	TicketDTO createTicket(TicketDTO ticketDTO);

	TicketDTO updateTicket(String id, TicketDTO ticketDTO);

}
