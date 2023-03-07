package com.example.hr.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HrKafkaListener {
		
	
	@KafkaListener(topics = "hr-commands", groupId = "hr")
	public void listenCommands(String hrCommand) {
		System.err.println("New command has arrived: %s".formatted(hrCommand));
	}
	
}
