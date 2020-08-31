package com.mehmetpekdemir.ticketservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.ticketservice.entity.Ticket;
import com.mehmetpekdemir.ticketservice.entity.elasticsearch.TicketES;
import com.mehmetpekdemir.ticketservice.repository.TicketElasticSearchRepository;
import com.mehmetpekdemir.ticketservice.service.TicketElasticSearchService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor // Constructor Injection with lombok
public class TicketElasticSearchServiceImpl implements TicketElasticSearchService {

	private final TicketElasticSearchRepository ticketElasticSearchRepository;

	@Transactional
	@Override
	public void createTicket(Ticket ticket, String firstNameAndLastName) {
		final TicketES model = TicketES.builder().id(ticket.getId()).description(ticket.getDescription())
				.notes(ticket.getNotes()).assignee(firstNameAndLastName)
				.priorityType(ticket.getPriorityType().getLabel()).ticketStatus(ticket.getTicketStatus().getLabel())
				.ticketDate(ticket.getTicketDate()).build();

		ticketElasticSearchRepository.save(model);

	}

}
