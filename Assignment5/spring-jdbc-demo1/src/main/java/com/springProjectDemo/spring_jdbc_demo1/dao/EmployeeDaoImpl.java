package com.springProjectDemo.spring_jdbc_demo1.dao;

import com.springProjectDemo.spring_jdbc_demo1.entities.Employee;
import com.springProjectDemo.spring_jdbc_demo1.entities.EmployeeRowMapper;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDaoImpl implements EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addEmployee(Employee employee) {
		String query = "insert into employee (empId, name, email) values (?,?,?)";
		int result = jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getEmail());
		return result;
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String query = "UPDATE employee SET name=?, email=? WHERE empId=?";
		jdbcTemplate.update(query, employee.getName(), employee.getEmail(), employee.getId());

	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		String query = "delete from employee where empId=?";
		jdbcTemplate.update(query, id);
		System.out.println("deteled record with id=" + id);

	}

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub

		String SQL = "select * from employee where empId=?";
		EmployeeRowMapper emp = new EmployeeRowMapper();
		Employee employee = jdbcTemplate.queryForObject(SQL, emp, id);
		return employee;
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		String SQL = "select * from employee";
		EmployeeRowMapper emp = new EmployeeRowMapper();
		List<Employee> employee = jdbcTemplate.query(SQL, emp);
		return employee;

	}

}
