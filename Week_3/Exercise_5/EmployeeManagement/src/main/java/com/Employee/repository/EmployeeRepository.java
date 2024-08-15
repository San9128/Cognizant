package com.Employee.repository;

import com.Employee.entity.Employee;

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

@Query(name = "Employee.findByName")

List<Employee> findByNameNamedQuery(@Param("name") String name);

}