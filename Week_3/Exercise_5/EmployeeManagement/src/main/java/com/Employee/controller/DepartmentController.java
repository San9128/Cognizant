package com.Employee.controller;



import com.Employee.entity.Department;

import com.Employee.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;

@RestController

@RequestMapping("/departments")

public class DepartmentController {

@Autowired

private DepartmentRepository departmentRepository;

// Create a new Department

@PostMapping

public Department createDepartment(@RequestBody Department department) {

return departmentRepository.save(department);

}

// Get all Departments

@GetMapping

public List<Department> getAllDepartments() {

return departmentRepository.findAll();

}

// Get Department by ID

@GetMapping("/{id}")

public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {

Optional<Department> department = departmentRepository.findById(id);

return department.map(ResponseEntity::ok)

.orElseGet(() -> ResponseEntity.notFound().build());

}

// Update a Department

@PutMapping("/{id}")

public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {

Optional<Department> departmentOptional = departmentRepository.findById(id);

if (departmentOptional.isPresent()) {

Department department = departmentOptional.get();

department.setName(departmentDetails.getName());

final Department updatedDepartment = departmentRepository.save(department);

return ResponseEntity.ok(updatedDepartment);

} else {

return ResponseEntity.notFound().build();

}

}

// Delete a Department

@DeleteMapping("/{id}")

public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {

if (departmentRepository.existsById(id)) {

departmentRepository.deleteById(id);

return ResponseEntity.ok().build();

} else {

return ResponseEntity.notFound().build();

}

}

}
