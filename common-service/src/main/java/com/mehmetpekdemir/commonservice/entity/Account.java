package com.mehmetpekdemir.commonservice.entity;

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

	@Column(value = "first_name")
	private String firstName;

	@Column(value = "last_name")
	private String lastName;

	@Column(value = "user_name")
	private String username;

	@Column(value = "email")
	private String email;

	@Column(value = "password")
	private String password;

	@Column(value = "is_active")
	private Boolean active;

	public Account(String firstName, String lastName, String username, String email, String password, Boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;
	}

}
