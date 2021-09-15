package com.example.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

  private @Id @GeneratedValue Long id;
  private String name;
  private String age;
  private String address;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
}
public Employee(Long id, String name, String age, String address) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.address = address;
}
public Employee() {
	super();
}
  
}
