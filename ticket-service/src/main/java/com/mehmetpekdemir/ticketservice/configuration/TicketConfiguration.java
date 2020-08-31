package com.mehmetpekdemir.ticketservice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Configuration
@EnableJpaRepositories("com.mehmetpekdemir")
@EnableElasticsearchRepositories
@ComponentScan("com.mehmetpekdemir")
public class TicketConfiguration {

}
