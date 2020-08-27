package com.mehmetpekdemir.commonservice.shared;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
public final class GenericResponse {

	private String message;

	private LocalDate date;

	public GenericResponse(String message) {
		this.message = message;
		this.date = LocalDate.now();
	}
}
