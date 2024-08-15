package com.Employee.repository.secondary;

import com.Employee.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface SecondaryEmployeeRepository extends JpaRepository<Department, Long> {

}