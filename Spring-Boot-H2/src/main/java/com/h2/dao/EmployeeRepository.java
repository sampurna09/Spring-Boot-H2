package com.h2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByDept(String dept);

}
