package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@GetMapping(value = "/employees")
	public List<Employee> getAll() {
		return service.findAll();
	}

	@PostMapping(value = "/employee")
	public String addEmployee(@RequestBody Employee employee) {
		service.saveEmployee(employee);
		return "Save Success";
	}

	@PutMapping(value = "/employee/{id}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		employee.setId(id);
		service.saveEmployee(employee);
		return "Update Success";
	}

	@DeleteMapping(value = "/employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		try {
			service.deleteEmployee(id);
			return "Delete Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "Delete Fail";
	}


}
