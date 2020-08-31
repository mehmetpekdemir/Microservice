package com.mehmetpekdemir.commonservice.client.contract;

import java.io.Serializable;

import com.mehmetpekdemir.commonservice.entity.Account;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
public final class AccountViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String id;

	private final String firstName;

	private final String lastName;

	private final String username;

	private final String email;

	private AccountViewDTO(String id, String firstName, String lastName, String username, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
	}

	public static AccountViewDTO of(Account account) {
		return new AccountViewDTO(account.getId(), account.getFirstName(), account.getLastName(), account.getUsername(),
				account.getEmail());
	}

	public String getFirstNameAndLastName() {
		return this.firstName + " " + this.lastName;
	}

}
