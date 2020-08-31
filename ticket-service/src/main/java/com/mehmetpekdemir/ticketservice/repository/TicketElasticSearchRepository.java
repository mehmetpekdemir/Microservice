package com.mehmetpekdemir.ticketservice.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.ticketservice.entity.elasticsearch.TicketES;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface TicketElasticSearchRepository extends ElasticsearchRepository<TicketES, String> {

}
