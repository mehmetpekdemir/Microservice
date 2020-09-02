package com.mehmetpekdemir.ticketservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.ticketservice.dto.TicketDTO;
import com.mehmetpekdemir.ticketservice.service.TicketService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("api/")
@RequiredArgsConstructor // Constructor Injection with lombok
public class TicketAPI {

	private final TicketService ticketService;

	@PostMapping("v1/ticket")
	public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
		return ResponseEntity.ok(ticketService.createTicket(ticketDTO));
	}

}
