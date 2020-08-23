package com.mehmetpekdemir.accountservice.dto;

import java.io.Serializable;

import com.mehmetpekdemir.accountservice.entity.Account;

import lombok.Getter;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
public final class AccountViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String firstName;

	private final String lastName;

	private final String username;

	private final String email;

	private AccountViewDTO(String firstName, String lastName, String username, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
	}

	public static AccountViewDTO of(Account account) {
		return new AccountViewDTO(account.getFirstName(), account.getLastName(), account.getUsername(),
				account.getEmail());
	}

}
