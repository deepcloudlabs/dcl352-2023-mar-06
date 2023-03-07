package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.events.EmployeeHiredEvent;
import com.example.hr.application.business.exception.EmployeeAlreadyExists;
import com.example.hr.application.business.exception.EmployeeNotFound;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.repository.EmployeeRepository;

public class StandardHrApplication implements HrApplication {
	private final EmployeeRepository employeeRepository;
	
	public StandardHrApplication(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee hireEmployee(Employee employee) {
		var kimlikNo = employee.getKimlikNo();
		if (employeeRepository.exists(kimlikNo))
			throw new EmployeeAlreadyExists(kimlikNo);
		var persistedEmployee = employeeRepository.persist(employee);
		var event = new EmployeeHiredEvent();
		return persistedEmployee;
	}

	@Override
	public Employee fireEmployee(TcKimlikNo kimlikNo) {
		if (!employeeRepository.exists(kimlikNo))
			throw new EmployeeNotFound(kimlikNo);
		return employeeRepository.remove(kimlikNo);
	}

	@Override
	public Optional<Employee> getEmployeeByKimlikNo(TcKimlikNo kimlikNo) {
		return employeeRepository.findByTcKimlikNo(kimlikNo);
	}

}
