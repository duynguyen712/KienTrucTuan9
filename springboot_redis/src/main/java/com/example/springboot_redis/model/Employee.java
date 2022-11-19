package com.example.springboot_redis.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5123864197540652307L;
	
	private Integer empId;
	private String empName;
	private Double empSalary;
	
}
