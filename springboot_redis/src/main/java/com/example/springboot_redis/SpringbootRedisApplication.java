package com.example.springboot_redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot_redis.dao.EmployeeDao;
import com.example.springboot_redis.model.Employee;

@SpringBootApplication
public class SpringbootRedisApplication implements CommandLineRunner {

	@Autowired
	private EmployeeDao empDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		empDao.saveEmployee(new Employee(600, "Emp100", 2150.0));
		
		// save multi
		empDao.saveAllEmployees(
				Map.of(501, new Employee(501, "Emp1", 2396.0),
						502, new Employee(502, "Emp2", 2499.5),
						503, new Employee(503, "Emp3", 2324.75)
						)
				);
		
		empDao.updateEmployee(new Employee(503, "Emp3", 2325.25));
		
		empDao.deleteEmployee(500);
		
		empDao.getAllEmployee().forEach((k,v) -> System.out.println(k +" : "+v));
		
		System.out.println("Emp details for 501 : "+empDao.getOneEmployee(501));
	}

}
