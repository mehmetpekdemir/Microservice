package com.mehmetpekdemir.ticketservice.service;

import com.mehmetpekdemir.ticketservice.entity.Ticket;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface TicketNotificationService {

	void sendToQueue(Ticket ticket);
	
}
