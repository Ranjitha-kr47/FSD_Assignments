package com.springProjectDemo.spring_jdbc_demo1.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		  employee.setId(rs.getInt("empId"));
		  employee.setName(rs.getString("name"));
		  employee.setEmail(rs.getString("email"));
		return employee;
	}

}
