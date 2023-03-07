package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.entity.EmployeeEntity;
import com.example.hr.repository.EmployeeEntityRepository;
import com.example.hr.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryJpaAdapter implements EmployeeRepository {

	private final EmployeeEntityRepository empRepo;
	private final ModelMapper modelMapper;
	
	public EmployeeRepositoryJpaAdapter(EmployeeEntityRepository empRepo, ModelMapper modelMapper) {
		this.empRepo = empRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean exists(TcKimlikNo kimlikNo) {
		return empRepo.existsById(kimlikNo.getValue());
	}

	@Override
	@Transactional
	public Employee persist(Employee employee) {
		var entity = modelMapper.map(employee,EmployeeEntity.class);
		var persistedEntity = empRepo.save(entity);
		return modelMapper.map(persistedEntity,Employee.class);
	}

	@Override
	@Transactional
	public Employee remove(TcKimlikNo kimlikNo) {
		var entity = empRepo.findById(kimlikNo.getValue()).orElseThrow(() -> new IllegalArgumentException("Cannot find employee to delete."));
		empRepo.delete(entity);
		return modelMapper.map(entity, Employee.class);
	}

	@Override
	public Optional<Employee> findByTcKimlikNo(TcKimlikNo kimlikNo) {
		return empRepo.findById(kimlikNo.getValue())
				      .map(entity -> modelMapper.map(entity, Employee.class));
	}

}
