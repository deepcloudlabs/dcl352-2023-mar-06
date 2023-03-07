package com.example.hr.application.business.events;

public final class EmployeeHiredEvent extends HrEvent {

	public EmployeeHiredEvent() {
		super(EventType.EMPLOYEE_HIRED);
	}

}
