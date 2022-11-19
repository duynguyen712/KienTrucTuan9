package com.example.springboot_redis.dao;

import java.util.Map;

import com.example.springboot_redis.model.Employee;

public interface EmployeeDao {
	void saveEmployee(Employee emp);
	Employee getOneEmployee(Integer id);
	void updateEmployee(Employee emp);
	Map<Integer, Employee> getAllEmployee();
	void deleteEmployee(Integer id);
	void saveAllEmployees(Map<Integer, Employee> map);
}
