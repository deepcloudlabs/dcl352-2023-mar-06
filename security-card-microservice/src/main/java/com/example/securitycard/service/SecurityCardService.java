package com.example.securitycard.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SecurityCardService {
	@KafkaListener(topics = "${topic}")
	public void handleHrEvents(String event) {
		System.err.println("New event has been received: %s".formatted(event));
	}
}
