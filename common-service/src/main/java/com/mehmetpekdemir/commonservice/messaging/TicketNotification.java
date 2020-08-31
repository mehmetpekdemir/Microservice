package com.mehmetpekdemir.commonservice.messaging;

import java.io.Serializable;

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
public class TicketNotification implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ticketId;

	private String accountId;

	private String ticketDescription;

}
