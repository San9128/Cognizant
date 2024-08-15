package com.Employee.controller;

import com.Employee.entity.Employee;

import com.Employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping("/employees")

public class EmployeeController {

@Autowired

private EmployeeRepository employeeRepository;

// Create a new Employee

@PostMapping

public Employee createEmployee(@RequestBody Employee employee) {

return employeeRepository.save(employee);

}

// Get all Employees with pagination and sorting

@GetMapping

public Page<Employee> getAllEmployees(

@RequestParam(defaultValue = "0") int page,

@RequestParam(defaultValue = "10") int size,

@RequestParam(defaultValue = "id,asc") String[] sort) {

Sort.Direction direction = Sort.Direction.ASC;

if (sort[1].equalsIgnoreCase("desc")) {

direction = Sort.Direction.DESC;

}

Sort sortOrder = Sort.by(direction, sort[0]);

Pageable pageable = PageRequest.of(page, size, sortOrder);

return employeeRepository.findAll(pageable);

}

// Get Employees by Name with pagination and sorting

@GetMapping("/search")

public Page<Employee> getEmployeesByName(

@RequestParam String name,

@RequestParam(defaultValue = "0") int page,

@RequestParam(defaultValue = "10") int size,

@RequestParam(defaultValue = "id,asc") String[] sort) {

Sort.Direction direction = Sort.Direction.ASC;

if (sort[1].equalsIgnoreCase("desc")) {

direction = Sort.Direction.DESC;

}

Sort sortOrder = Sort.by(direction, sort[0]);

Pageable pageable = PageRequest.of(page, size, sortOrder);

return employeeRepository.findByName(name, pageable);

}

// Get Employees by Email with pagination and sorting

@GetMapping("/searchByEmail")

public Page<Employee> getEmployeesByEmail(

@RequestParam String email,

@RequestParam(defaultValue = "0") int page,

@RequestParam(defaultValue = "10") int size,

@RequestParam(defaultValue = "id,asc") String[] sort) {

Sort.Direction direction = Sort.Direction.ASC;

if (sort[1].equalsIgnoreCase("desc")) {

direction = Sort.Direction.DESC;

}

Sort sortOrder = Sort.by(direction, sort[0]);

Pageable pageable = PageRequest.of(page, size, sortOrder);

return employeeRepository.findByEmail(email, pageable);

}

// Get Employee by ID

@GetMapping("/{id}")

public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

Optional<Employee> employee = employeeRepository.findById(id);

return employee.map(ResponseEntity::ok)

.orElseGet(() -> ResponseEntity.notFound().build());

}

// Update an Employee

@PutMapping("/{id}")

public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {

Optional<Employee> employeeOptional = employeeRepository.findById(id);

if (employeeOptional.isPresent()) {

Employee employee = employeeOptional.get();

employee.setName(employeeDetails.getName());

employee.setEmail(employeeDetails.getEmail());

employee.setDepartment(employeeDetails.getDepartment());

final Employee updatedEmployee = employeeRepository.save(employee);

return ResponseEntity.ok(updatedEmployee);

} else {

return ResponseEntity.notFound().build();

}}



// Delete an Employee

@DeleteMapping("/{id}")

public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

if (employeeRepository.existsById(id)) {

employeeRepository.deleteById(id);

return ResponseEntity.ok().build();

} else {

return ResponseEntity.notFound().build();

}
}}

