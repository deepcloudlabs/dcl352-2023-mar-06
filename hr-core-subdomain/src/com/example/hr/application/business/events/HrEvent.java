package com.example.hr.application.business.events;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class HrEvent {
	private final EventType eventType;

	private final String eventId = UUID.randomUUID().toString();
	private final LocalDateTime timestamp = LocalDateTime.now();

	public HrEvent(EventType eventType) {
		this.eventType = eventType;
	}

	public String getEventId() {
		return eventId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public EventType getEventType() {
		return eventType;
	}

}
