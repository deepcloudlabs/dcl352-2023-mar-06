package com.example.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.StandardHrApplication;
import com.example.hr.application.business.events.HrEvent;
import com.example.hr.infra.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

@Configuration
public class AppConfig {

	@Bean
	HrApplication createHrApplication(EmployeeRepository employeeRepository,
			EventPublisher<HrEvent> eventPublisher) {
		return new StandardHrApplication(employeeRepository, eventPublisher);
	}
}
