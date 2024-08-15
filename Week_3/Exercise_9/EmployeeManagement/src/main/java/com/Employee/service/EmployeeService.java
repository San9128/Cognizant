package com.Employee.service;
import com.Employee.entity.Employee;

import org.hibernate.Session;

import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;

import java.util.List;

@Service

public class EmployeeService {

@PersistenceContext

private EntityManager entityManager;

@SuppressWarnings("deprecation")

public void batchInsertEmployees(List<EmployeeService> employees) {

Session session = entityManager.unwrap(Session.class);

Transaction transaction = session.beginTransaction();

int batchSize = 50;

for (int i = 0; i < employees.size(); i++) {

session.save(employees.get(i));

if (i % batchSize == 0 && i > 0) {

session.flush();

session.clear();

}

}

transaction.commit();

}

}