package com.Employee.entity;

import jakarta.persistence.*;

import lombok.Getter;

import lombok.Setter;

import java.util.List;

@Entity

@Table(name = "departments")

@Getter

@Setter

public class Department {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

private String name;

@OneToMany(mappedBy = "department")

private List<Employee> employees;

public Object getName() {
	// TODO Auto-generated method stub
	return this.name;
}

public void setName(Object name2) {
	
	this.name=(String)name2;
	// TODO Auto-generated method stub
	
}

// Constructors, if needed, can be added here

}