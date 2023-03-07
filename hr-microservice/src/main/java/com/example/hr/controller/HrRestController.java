package com.example.hr.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.response.EmployeeResponse;
import com.example.hr.dto.response.HireEmployeeResponse;
import com.example.hr.service.HrService;

@RestController
@RequestScope
@RequestMapping("employees")
@Validated
@CrossOrigin
public class HrRestController {
	private final HrService hrService;
	
	public HrRestController(HrService hrService) {
		this.hrService = hrService;
	}

	// GET http://localhost:8100/hr/api/v1/employees/11111111110
	@GetMapping(value="{kimlikNo}")
	public EmployeeResponse findEmployee(@PathVariable String kimlikNo) {
		return hrService.findEmployeeById(kimlikNo);
	}
	
	// POST http://localhost:8100/hr/api/v1/employees
	@PostMapping
	public HireEmployeeResponse hireEmployee(@RequestBody HireEmployeeRequest request) {
		return hrService.hireEmployee(request);
	}
	
	// DELETE http://localhost:8100/hr/api/v1/employees/11111111110
	@DeleteMapping("{kimlikNo}")
	public EmployeeResponse fireEmployee(@PathVariable String kimlikNo) {
		return hrService.fireEmployee(kimlikNo);		
	}
	
}
