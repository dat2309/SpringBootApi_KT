package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
@Service

public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository  empRepo;
	@Override
	public List<Employee> findAll() {
		List<Employee> list = empRepo.findAll();
		return list;
	}

	@Override
	public void saveEmployee(Employee entity) {
		Employee employeeEntity = new Employee();
		if (entity.getId() != null) {
			Optional<Employee> result = empRepo.findById(entity.getId());
			Employee oldEmp = null;
			if (result.isPresent()) {
				oldEmp = result.get();
			}
			oldEmp.setAddress(entity.getAddress());
			oldEmp.setAge(entity.getAge());
			
			oldEmp.setName(entity.getName());
			employeeEntity = oldEmp;
		} else {
			employeeEntity.setAddress(entity.getAddress());
			employeeEntity.setAge(entity.getAge());
			employeeEntity.setName(entity.getName());
		}

		empRepo.save(employeeEntity);
	}

	
	@Override
	public void deleteEmployee(long id) {
		if (empRepo.findById(id) == null) {
			return;
		}
		empRepo.deleteById(id);
	}	


}
