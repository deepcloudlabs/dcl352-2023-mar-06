package com.example.hr.dto.request;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.hr.domain.Department;
import com.example.hr.domain.FiatCurrency;
import com.example.hr.domain.JobStyle;
import com.example.hr.validation.Iban;
import com.example.hr.validation.TcKimlikNo;

import lombok.Data;

@Data
public class HireEmployeeRequest {
	@TcKimlikNo
	private String identity;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Iban
	private String iban;
	@Min(0)
	private double salary;
	@NotNull
	private FiatCurrency currency;
	private int birthYear;
	@NotBlank
	private String photo;
	private List<Department> departments;
	@NotNull
	private JobStyle jobStyle;
}
