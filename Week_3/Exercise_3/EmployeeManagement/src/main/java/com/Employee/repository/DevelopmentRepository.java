package com.Employee.repository;

import com.Employee.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface DevelopmentRepository extends JpaRepository<Department, Long> {

// Derived query methods

Department findByName(String name);

}