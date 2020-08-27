package com.mehmetpekdemir.commonservice.client.contract;

import lombok.Data;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
public class AccountCreateDTO {

	private String firstName;

	private String lastName;

	private String username;

	private String email;

	private String password;

	private Boolean active = true;

}
