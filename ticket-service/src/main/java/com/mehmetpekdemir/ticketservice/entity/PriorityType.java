package com.mehmetpekdemir.ticketservice.entity;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
public enum PriorityType {

	URGENT("Urgent"), LOW("Low"), HIGH("High");

	private String label;

	PriorityType(String label) {
		this.label = label;
	}

}
