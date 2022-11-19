package com.example.springboot_redis.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;

import com.example.springboot_redis.dao.EmployeeDao;
import com.example.springboot_redis.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private final String hashReference = "Employee";
	
	@Resource(name = "redisTemplate")
	private HashOperations<String, Integer, Employee> hashOperations;

	@Override
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		hashOperations.putIfAbsent(hashReference, emp.getEmpId(), emp);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		// TODO Auto-generated method stub
		return hashOperations.get(hashReference, id);
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		hashOperations.put(hashReference, emp.getEmpId(), emp);
	}

	@Override
	public Map<Integer, Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return hashOperations.entries(hashReference);
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		hashOperations.delete(hashReference, id);
	}

	@Override
	public void saveAllEmployees(Map<Integer, Employee> map) {
		// TODO Auto-generated method stub
		hashOperations.putAll(hashReference, map);
	}

}
