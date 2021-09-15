package com.example.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Employee;
@Service
public interface EmployeeService {

	public List<Employee> findAll();
	
	public void saveEmployee(Employee entity);

	public void deleteEmployee(long id);

}
