package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.events.EmployeeFiredEvent;
import com.example.hr.application.business.events.EmployeeHiredEvent;
import com.example.hr.application.business.events.HrEvent;
import com.example.hr.application.business.exception.EmployeeAlreadyExists;
import com.example.hr.application.business.exception.EmployeeNotFound;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.infra.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

public class StandardHrApplication implements HrApplication {
	private final EmployeeRepository employeeRepository;
	private final EventPublisher<HrEvent> eventPublisher;
	
	public StandardHrApplication(EmployeeRepository employeeRepository, EventPublisher<HrEvent> eventPublisher) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Employee hireEmployee(Employee employee) {
		var kimlikNo = employee.getKimlikNo();
		if (employeeRepository.exists(kimlikNo))
			throw new EmployeeAlreadyExists(kimlikNo);
		var persistedEmployee = employeeRepository.persist(employee);
		var event = new EmployeeHiredEvent(kimlikNo);
		eventPublisher.emit(event);
		return persistedEmployee;
	}

	@Override
	public Employee fireEmployee(TcKimlikNo kimlikNo) {
		if (!employeeRepository.exists(kimlikNo))
			throw new EmployeeNotFound(kimlikNo);
		Employee firedEmployee = employeeRepository.remove(kimlikNo);
		var event = new EmployeeFiredEvent(firedEmployee);
		eventPublisher.emit(event);		
		return firedEmployee;
	}

	@Override
	public Optional<Employee> getEmployeeByKimlikNo(TcKimlikNo kimlikNo) {
		return employeeRepository.findByTcKimlikNo(kimlikNo);
	}

}
