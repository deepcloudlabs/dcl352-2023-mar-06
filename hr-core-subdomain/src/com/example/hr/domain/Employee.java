package com.example.hr.domain;

import java.util.List;

import com.example.ddd.Entity;

// Entity Class -> Persistent
//                 Identity
//                 Mutable -> Business Method
//                 
// Ubiquitous Language: Employee, TcKimlikNo, FullName, Money, Iban,...
@Entity(identity="kimlikNo")
public class Employee {
	private final TcKimlikNo kimlikNo;
	private FullName fullName;
	private Money salary;
	private Iban iban;
	private BirthYear birthYear;
	private Photo photo;
	private List<Department> departments;
	private JobStyle jobStyle;
}
