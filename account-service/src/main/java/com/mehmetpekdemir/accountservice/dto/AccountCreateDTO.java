package com.mehmetpekdemir.accountservice.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
public class AccountCreateDTO {

	@NotNull
	@Size(min = 3, max = 50)
	private String firstName;

	@NotNull
	@Size(min = 2, max = 50)
	private String lastName;

	@NotNull
	@Size(min = 6, max = 32)
	private String username;

	@NotNull
	@Size(min = 10, max = 128)
	private String email;

	@NotNull
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
	private String password;

	private Boolean active = true;

}
