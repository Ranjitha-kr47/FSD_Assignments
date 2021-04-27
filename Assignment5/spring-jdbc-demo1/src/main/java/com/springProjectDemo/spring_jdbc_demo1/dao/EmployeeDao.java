package com.springProjectDemo.spring_jdbc_demo1.dao;

import java.util.List;

import com.springProjectDemo.spring_jdbc_demo1.entities.*;

public interface EmployeeDao {
	public int addEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(int id);

	public Employee getEmployee(int id);

	public List<Employee> getAllEmployees();
}
