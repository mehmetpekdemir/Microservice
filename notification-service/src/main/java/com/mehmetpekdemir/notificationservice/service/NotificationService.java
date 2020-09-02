package com.mehmetpekdemir.notificationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.mehmetpekdemir.commonservice.messaging.TicketNotification;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@EnableBinding(Sink.class)
public class NotificationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

	@StreamListener(Sink.INPUT)
	public void onNotification(TicketNotification ticketNotification) {
		LOGGER.info("Notification sending...");
		LOGGER.info(ticketNotification.toString());
	}
}
