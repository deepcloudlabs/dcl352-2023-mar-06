package com.example.hr.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.example.hr.domain.Department;
import com.example.hr.domain.FiatCurrency;
import com.example.hr.domain.JobStyle;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class EmployeeEntity {
	@Id
	private String identity;
	@Column(name = "fname")
	private String firstName;
	@Column(name = "lname")
	private String lastName;
	private String iban;
	private double salary;
	@Enumerated(EnumType.STRING)
	private FiatCurrency currency;
	@Column(name = "byear")
	private int birthYear;
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] photo;
	@Enumerated(EnumType.ORDINAL)
	@ElementCollection
	private List<Department> departments;
	@Enumerated(EnumType.ORDINAL)
	private JobStyle jobStyle;

}
