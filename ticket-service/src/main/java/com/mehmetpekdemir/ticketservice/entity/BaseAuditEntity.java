package com.mehmetpekdemir.ticketservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@MappedSuperclass
public abstract class BaseAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@CreatedDate
	@Column(name = "created_at")
	private Date cretedAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;

}
