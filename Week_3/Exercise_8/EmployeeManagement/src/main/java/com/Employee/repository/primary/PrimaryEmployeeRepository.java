package com.Employee.repository.primary;

import com.Employee.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface PrimaryEmployeeRepository extends JpaRepository<Employee, Long> {

}