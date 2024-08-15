package com.Employee.repository;

import com.Employee.entity.Employee;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

// Derived query methods

List<Employee> findByName(String name);

List<Employee> findByEmail(String email);

// Custom query with @Query annotation

@Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")

List<Employee> findByDepartmentNameCustom(@Param("departmentName") String departmentName);

// Paginated and sorted queries

Page<Employee> findByName(String name, Pageable pageable);

Page<Employee> findByEmail(String email, Pageable pageable);

// Paginated and sorted query for custom department name

@Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")

Page<Employee> findByDepartmentNameCustomPaginated(@Param("departmentName") String departmentName, Pageable pageable);

}