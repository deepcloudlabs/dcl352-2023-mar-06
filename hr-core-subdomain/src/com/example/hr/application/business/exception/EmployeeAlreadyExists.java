package com.example.hr.application.business.exception;

import com.example.hr.domain.TcKimlikNo;

@SuppressWarnings("serial")
public class EmployeeAlreadyExists extends RuntimeException {
	private final TcKimlikNo kimlikNo;

	public EmployeeAlreadyExists(TcKimlikNo kimlikNo) {
		super("Employee already exists.");
		this.kimlikNo = kimlikNo;
	}

	public TcKimlikNo getKimlikNo() {
		return kimlikNo;
	}

}
