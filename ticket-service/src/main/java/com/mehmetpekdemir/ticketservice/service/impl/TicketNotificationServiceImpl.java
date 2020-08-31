package com.mehmetpekdemir.ticketservice.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.mehmetpekdemir.commonservice.messaging.TicketNotification;
import com.mehmetpekdemir.ticketservice.entity.Ticket;
import com.mehmetpekdemir.ticketservice.service.TicketNotificationService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor // Constructor Injection with lombok
public class TicketNotificationServiceImpl implements TicketNotificationService {

	private final Source source;

	@Override
	public void sendToQueue(Ticket ticket) {
		final TicketNotification ticketNotification = TicketNotification.builder().accountId(ticket.getAssignee())
				.ticketId(ticket.getId()).ticketDescription(ticket.getDescription()).build();

		source.output().send(MessageBuilder.withPayload(ticketNotification).build());
	}

}
