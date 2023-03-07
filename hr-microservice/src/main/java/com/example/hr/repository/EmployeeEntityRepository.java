package com.example.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hr.entity.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, String> {
    List<EmployeeEntity> findAllByBirthYearBetween(int fromYear,int toYear);
    List<EmployeeEntity> findTop10ByOrderBySalaryDesc();
}
