package com.mehmetpekdemir.gateway.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/fb")
public class HystrixAPI {

	@GetMapping("/account")
	public String accountFallback() {
		return "Account Service is not available.";
	}

	@GetMapping("/ticket")
	public String ticketFallback() {
		return "Ticket Service is not available.";
	}

}
