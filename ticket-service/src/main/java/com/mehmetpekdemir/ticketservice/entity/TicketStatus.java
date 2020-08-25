package com.mehmetpekdemir.ticketservice.entity;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
public enum TicketStatus {

	OPEN("Open"), IN_PROGRESS("In progress"), RESOLVED("Resolved"), CLOSED("Closed");

	private String label;

	TicketStatus(String label) {
		this.label = label;
	}

}
