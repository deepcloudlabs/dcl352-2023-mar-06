package com.example.hr.domain;

import com.example.ddd.ValueObject;

@ValueObject
public enum JobStyle {
	PART_TIME(100), FULL_TIME(200), INTERN(300);
	
	private final int value;

	private JobStyle(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
