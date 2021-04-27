package Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {
	private static Statement statement = null;
	private Connection conn;

	public EmployeeDaoImpl() throws SQLException {
		conn = ConnectionFactory.getConnection();
		statement = conn.createStatement();
	}

	@Override
	public void addEmployee(Employee employee) {
		String sql = "insert into employee values (" + employee.getEmpId() + ",'" + employee.getName() + "','"
				+ employee.getEmail() + "')";
		int count = 0;
		try {
			count = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (count > 0) {
			System.out.println("Employee added");
		} else {
			System.out.println("employee not added");
		}
	}

	@Override
	public void updateEmployee(Employee employee) {

		String sql = "update employee set name='" + employee.getName() + "', email='" + employee.getEmail()
				+ "' where empId=" + employee.getEmpId();

		int count = 0;
		try {
			count = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (count > 0) {
			System.out.println("Employee data updated");
		} else {
			System.out.println("employee data not updated");
		}
	}

	@Override
	public void deleteEmployee(int empId) {
		String sql = "delete from employee where empId=" + empId;
		int count = 0;
		try {
			count = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (count > 0) {
			System.out.println("Employee deleted");
		} else {
			System.out.println("employee not deleted");
		}

	}

	@Override
	public Employee getEmployeeById(int empId) {
		Employee employee = null;
		String sql = "select * from employee where empId=" + empId;
		try {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int empid = rs.getInt("empId");
				String name = rs.getString("name");
				String email = rs.getString("email");
				employee = new Employee(empId, name, email);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public List<Employee> getEmployees() {

		List<Employee> list = new ArrayList<>();
		String sql = "select * from employee";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int empid = rs.getInt("empid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Employee employee = new Employee(empid, name, email);
				list.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
