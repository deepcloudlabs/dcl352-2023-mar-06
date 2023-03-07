package com.example.hr.application.business.exception;

import com.example.hr.domain.TcKimlikNo;

@SuppressWarnings("serial")
public class EmployeeNotFound extends RuntimeException {
	private final TcKimlikNo kimlikNo;

	public EmployeeNotFound(TcKimlikNo kimlikNo) {
		super("Employee already exists.");
		this.kimlikNo = kimlikNo;
	}

	public TcKimlikNo getKimlikNo() {
		return kimlikNo;
	}

}
