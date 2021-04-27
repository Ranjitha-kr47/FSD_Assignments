package com.springProjectDemo.spring_jdbc_demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springProjectDemo.spring_jdbc_demo1.dao.EmployeeDaoImpl;
import com.springProjectDemo.spring_jdbc_demo1.entities.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Application started...");
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		EmployeeDaoImpl dao = context.getBean("empDao", EmployeeDaoImpl.class);

		// inserting employee
//        employee.setId(3);
//      employee.setName("Smith");
//        employee.setEmail("s@gmail.com");

//        List<Employee> list = daoImpl.getAllEmployees();
//		for (Employee emp : list) {
//			System.out.println(emp.toString());
//      

		// daoImpl.addEmployee(employee);
		// System.out.println("("+result+") rows updated..");

		// deleting employee
		// daoImpl.deleteEmployee(8);

		// daoImpl.updateEmployee(employee);

		// dao.getEmployee(1);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;

		while (flag) {
			System.out.println("___________________________");
			System.out.println("Press 1:Add Employee");
			System.out.println("Press 2:get all Employee details");
			System.out.println("Press 3:get Employee by id");
			System.out.println("Press 4:update Employee");
			System.out.println("Press 5:delete Employee");
			System.out.println("Press 6:exit");
			System.out.println("___________________________");

			try {
				int input = Integer.parseInt(reader.readLine());

				switch (input) {
				case 1:
					// add employee
					System.out.print("enter id: ");
					int id = Integer.parseInt(reader.readLine());

					System.out.print("enter name: ");
					String name = reader.readLine();

					System.out.print("enter email: ");
					String email = reader.readLine();

					Employee employee1 = new Employee();
					employee1.setId(id);
					employee1.setName(name);
					employee1.setEmail(email);

					dao.addEmployee(employee1);
					System.out.println("Employee added successfully");

					break;

				case 2:
					// get all employees
					List<Employee> employees = dao.getAllEmployees();
					for (Employee employee : employees) {
						System.out.println(employee.toString());
					}
					break;

				case 3:
					// get employee by id
					System.out.print("enter id: ");
					int id4 = Integer.parseInt(reader.readLine());

					Employee employee3 = dao.getEmployee(id4);
					System.out.println(employee3);
					break;

				case 4:

					// update employee
					System.out.print("enter id: ");
					int id2 = Integer.parseInt(reader.readLine());

					System.out.print("enter name: ");
					String name2 = reader.readLine();

					System.out.print("enter email: ");
					String email2 = reader.readLine();

					Employee employee2 = new Employee();
					employee2.setId(id2);
					employee2.setName(name2);
					employee2.setEmail(email2);

					dao.updateEmployee(employee2);
					System.out.println("Employee updated successfully");
					break;

				case 5:
					// delete employee
					System.out.print("enter id: ");
					int id3 = Integer.parseInt(reader.readLine());

					dao.deleteEmployee(id3);
					System.out.println("Employee deleted successfully");
					break;

				case 6:
					flag = false;
					System.out.println("Thank you");
					break;

				default:
					break;

				}
			} catch (Exception e) {
				System.out.println("invalid entry");
			}
		}

	}
}
