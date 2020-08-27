package com.mehmetpekdemir.ticketservice.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.ticketservice.dto.TicketDTO;
import com.mehmetpekdemir.ticketservice.service.TicketService;

import lombok.RequiredArgsConstructor;

/**
 * <p>
 * Port: localhost: 8041
 * </p>
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor // Constructor Injection with lombok
public class TicketAPI {

	private final TicketService ticketService;

	@GetMapping("v1/ticket/{id}")
	public ResponseEntity<TicketDTO> getTicketById(@PathVariable("id") String id) {
		return ResponseEntity.ok(ticketService.getTicketById(id));
	}

	@GetMapping("v1/ticket/slice")
	public ResponseEntity<Page<TicketDTO>> paginationForTickets(Pageable pageable) {
		return ResponseEntity.ok(ticketService.paginationForTickets(pageable));
	}

	@PostMapping("v1/ticket")
	public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
		return ResponseEntity.ok(ticketService.createTicket(ticketDTO));
	}

	@PutMapping("v1/ticket/{id}")
	public ResponseEntity<TicketDTO> updateTicket(@PathVariable("id") String id, @RequestBody TicketDTO ticketDTO) {
		return ResponseEntity.ok(ticketService.updateTicket(id, ticketDTO));
	}

}
