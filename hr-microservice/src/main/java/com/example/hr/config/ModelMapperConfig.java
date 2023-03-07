package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.response.EmployeeResponse;
import com.example.hr.entity.EmployeeEntity;

@Configuration
public class ModelMapperConfig {
	private static final Converter<Employee,EmployeeResponse> 
	EMPLOYEE_TO_EMPLOYEE_RESPONSE_CONVERTER = context -> {
		var response = new EmployeeResponse();
		var employee = context.getSource();
		response.setIdentity(employee.getKimlikNo().getValue());
		response.setFirstName(employee.getFullName().firstName());
		response.setLastName(employee.getFullName().lastName());
		response.setSalary(employee.getSalary().value());
		response.setCurrency(employee.getSalary().currency());
		response.setIban(employee.getIban().getValue());
		response.setDepartments(employee.getDepartments());
		response.setJobStyle(employee.getJobStyle());
		response.setBirthYear(employee.getBirthYear().value());
		response.setPhoto(employee.getPhoto().getBase64Values());
		return response;
	};
	private static final Converter<Employee,EmployeeEntity> 
	EMPLOYEE_TO_EMPLOYEE_ENTITY_CONVERTER = context -> {
		var entity = new EmployeeEntity();
		var employee = context.getSource();
		entity.setIdentity(employee.getKimlikNo().getValue());
		entity.setFirstName(employee.getFullName().firstName());
		entity.setLastName(employee.getFullName().lastName());
		entity.setSalary(employee.getSalary().value());
		entity.setCurrency(employee.getSalary().currency());
		entity.setIban(employee.getIban().getValue());
		entity.setDepartments(employee.getDepartments());
		entity.setJobStyle(employee.getJobStyle());
		entity.setBirthYear(employee.getBirthYear().value());
		entity.setPhoto(employee.getPhoto().getValues());
		return entity;
	};
	
	private static final Converter<HireEmployeeRequest,Employee> 
	HIRE_EMPLOYEE_REQUEST_TO_EMPLOYEE_CONVERTER = context -> {
		var request = context.getSource();
		var employee = new Employee.Builder(TcKimlikNo.valueOf(request.getIdentity()))
					.fullName(request.getFirstName(),request.getLastName())
					.birthYear(request.getBirthYear())
					.salary(request.getSalary())
					.jobStyle(request.getJobStyle())
					.iban(request.getIban())
					.departments(request.getDepartments())
					.photo(request.getPhoto())
				    .build();
		return employee;
	};
	
	private static final Converter<EmployeeEntity,Employee> 
	EMPLOYEE_ENTITY_TO_EMPLOYEE_CONVERTER = context -> {
		var entity = context.getSource();
		var employee = new Employee.Builder(TcKimlikNo.valueOf(entity.getIdentity()))
				.fullName(entity.getFirstName(),entity.getLastName())
				.birthYear(entity.getBirthYear())
				.salary(entity.getSalary())
				.jobStyle(entity.getJobStyle())
				.iban(entity.getIban())
				.departments(entity.getDepartments())
				.photo(entity.getPhoto())
				.build();
		return employee;
	};
	
	@Bean
	ModelMapper createModelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(EMPLOYEE_TO_EMPLOYEE_ENTITY_CONVERTER, Employee.class, EmployeeEntity.class);
		modelMapper.addConverter(EMPLOYEE_ENTITY_TO_EMPLOYEE_CONVERTER, EmployeeEntity.class, Employee.class);
		modelMapper.addConverter(EMPLOYEE_TO_EMPLOYEE_RESPONSE_CONVERTER, Employee.class, EmployeeResponse.class);
		modelMapper.addConverter(HIRE_EMPLOYEE_REQUEST_TO_EMPLOYEE_CONVERTER, 
				HireEmployeeRequest.class, Employee.class);
		return modelMapper;
	}
}
