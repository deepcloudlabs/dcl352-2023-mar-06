package com.example.hr.application.business.events;

import com.example.hr.domain.Employee;

public final class EmployeeFiredEvent extends HrEvent {
	private final Employee employee;

	public EmployeeFiredEvent(Employee employee) {
		super(EventType.EMPLOYEE_FIRED);
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

}
