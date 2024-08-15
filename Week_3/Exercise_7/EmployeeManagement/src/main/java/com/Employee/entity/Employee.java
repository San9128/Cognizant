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

@Table(name = "employees")

@Getter

@Setter

@NamedQueries({

@NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),

@NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")

})

public class Employee {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

private String name;

private String email;

@ManyToOne

@JoinColumn(name = "department_id")

private Department department;

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

public Object getEmail() {
	// TODO Auto-generated method stub
	return this.email;
}

public void setEmail(Object email2) {
	// TODO Auto-generated method stub
	this.email=(String)email2;
}

public Object getDepartment() {
	// TODO Auto-generated method stub
	return this.department;
}

public void setDepartment(Object department2) {
	// TODO Auto-generated method stub
	this.department=(Department)department2;
}



// Constructors, if needed, can be added here

}