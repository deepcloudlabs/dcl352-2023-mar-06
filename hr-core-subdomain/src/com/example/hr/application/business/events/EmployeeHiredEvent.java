package com.example.hr.application.business.events;

import com.example.hr.domain.TcKimlikNo;

public final class EmployeeHiredEvent extends HrEvent {
	private final TcKimlikNo kimlikNo;

	public EmployeeHiredEvent(TcKimlikNo kimlikNo) {
		super(EventType.EMPLOYEE_HIRED);
		this.kimlikNo = kimlikNo;
	}

	public TcKimlikNo getKimlikNo() {
		return kimlikNo;
	}

}
