package com.example.hr.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorMessage {
	private final String message;
	private final String status;
}
