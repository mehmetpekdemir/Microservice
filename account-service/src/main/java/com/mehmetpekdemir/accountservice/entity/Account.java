package com.mehmetpekdemir.accountservice.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(value = "accounts")
public class Account {

	@PrimaryKey
	private String id = UUID.randomUUID().toString();

	@Column(value = "uname")
	private String username;

	@Column(value = "email")
	private String email;

	@Column(value = "password")
	private String hashPassword;

	public Account(String username, String email, String hashPassword) {
		this.username = username;
		this.email = email;
		this.hashPassword = hashPassword;
	}

}
