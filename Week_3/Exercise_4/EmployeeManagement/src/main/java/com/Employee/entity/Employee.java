package com.Employee.entity;

import jakarta.persistence.*;

import lombok.Getter;

import lombok.Setter;

@Entity

@Table(name = "employees")

@Getter

@Setter

public class Employee {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

private String name;

private String email;

@ManyToOne

@JoinColumn(name = "department_id")

private Department department;

public Object getName() {
	// TODO Auto-generated method stub
	return this.name;
}

public Object getEmail() {
	// TODO Auto-generated method stub
	return this.email;
}

public Object getDepartment() {
	// TODO Auto-generated method stub
	return this.department;
}

public void setName(Object name2) {
	// TODO Auto-generated method stub
	this.name=(String)name2;
}

public void setEmail(Object email2) {
	this.email=(String)email2;
	// TODO Auto-generated method stub
	
}

public void setDepartment(Object department2) {
	// TODO Auto-generated method stub
	this.department=(Department)department2;
}

// Constructors, if needed, can be added here

}