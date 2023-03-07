package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.application.business.events.HrEvent;
import com.example.hr.infra.EventPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventPublisherKafkaAdapter implements EventPublisher<HrEvent> {
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper;
	private final String hrEventTopic;
	

	public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, 
			ObjectMapper objectMapper,
			@Value("${hrEventTopic}") String hrEventTopic) {
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
		this.hrEventTopic = hrEventTopic;
	}


	@Override
	public void emit(HrEvent event) {
		try {
			var eventAsJson = objectMapper.writeValueAsString(event);
			kafkaTemplate.send(hrEventTopic, eventAsJson);			
		}catch (Exception e) {
			System.err.println("Error has occured while converting the event to json: %s".formatted(e.getMessage()));
		}
		
	}

}
