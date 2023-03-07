package com.example.hr.repository;

import java.util.Optional;

import com.example.hexagon.Port;
import com.example.hexagon.PortType;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

@Port(PortType.DRIVEN_PORT)
public interface EmployeeRepository {

	boolean exists(TcKimlikNo kimlikNo);

	Employee persist(Employee employee);

	Employee remove(TcKimlikNo kimlikNo);

	Optional<Employee> findByTcKimlikNo(TcKimlikNo kimlikNo);

}
