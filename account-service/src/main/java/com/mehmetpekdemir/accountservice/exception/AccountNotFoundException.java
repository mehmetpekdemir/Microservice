package com.mehmetpekdemir.accountservice.exception;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String message) {
		super(message);
	}

}
