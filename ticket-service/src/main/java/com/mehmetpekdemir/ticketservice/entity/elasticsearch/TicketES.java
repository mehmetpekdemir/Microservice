package com.mehmetpekdemir.ticketservice.entity.elasticsearch;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(of = "id")
@Document(indexName = "ticket")
public class TicketES implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String description;

	private String notes;

	private String assignee;

	private Date ticketDate;

	private String priorityType;

	private String ticketStatus;

}
