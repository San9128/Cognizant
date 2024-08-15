package com.Employee.entity;

import jakarta.persistence.*;

import lombok.Getter;

import lombok.Setter;

import org.springframework.data.annotation.CreatedBy;

import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.annotation.LastModifiedBy;

import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

import java.util.List;

@Entity

@Table(name = "departments")

@Getter

@Setter

@NamedQueries({

@NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name")

})

public class Department {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

private String name;

@OneToMany(mappedBy = "department")

private List<Employee> employees;

@CreatedDate

@Column(name = "created_date", updatable = false)

private LocalDateTime createdDate;

@LastModifiedDate

@Column(name = "last_modified_date")

private LocalDateTime lastModifiedDate;

@CreatedBy

@Column(name = "created_by")

private String createdBy;

@LastModifiedBy

@Column(name = "last_modified_by")

private String lastModifiedBy;

public Object getName() {
	// TODO Auto-generated method stub
	return this.name;
}

public void setName(Object name2) {
	// TODO Auto-generated method stub
	this.name=(String)name2;
}

// Constructors, if needed, can be added here

}