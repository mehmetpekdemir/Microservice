package com.mehmetpekdemir.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.ticketservice.entity.Ticket;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

}
