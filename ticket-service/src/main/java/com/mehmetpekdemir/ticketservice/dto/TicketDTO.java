package com.mehmetpekdemir.ticketservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDTO {

	private String id;

	private String description;

	private String notes;

	private String assignee;

	private Date ticketDate;

	private String priorityType;

	private String ticketStatus;

}
