package com.mehmetpekdemir.ticketservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" }, callSuper = true)
@Entity
@Table(name = "tickets")
public class Ticket extends BaseAuditEntity {

	private static final long serialVersionUID = 1L;

	@Getter
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	@Getter
	@Setter
	@Column(name = "description", length = 600)
	private String description;

	@Getter
	@Setter
	@Column(name = "notes", length = 4000)
	private String notes;

	@Getter
	@Setter
	@Column(name = "assignee", length = 50)
	private String assignee;

	@Getter
	@Setter
	@Column(name = "ticket_date")
	private Date ticketDate;

	@Getter
	@Setter
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "priority_type")
	private PriorityType priorityType;

	@Getter
	@Setter
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ticket_status")
	private TicketStatus ticketStatus;

}
