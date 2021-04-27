package Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		// EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		System.out.println("Please select any one options");
		System.out.println("**************");
		System.out.println("Press 1: Insert");
		System.out.println("Press 2: Update");
		System.out.println("Press 3: Delete");
		System.out.println("Press 4: Get");
		System.out.println("Press 5:GetBy Id");
		System.out.println("**************");

		int option = sc.nextInt();
		switch (option) {
		case 1: {
			insert();
			break;
		}
		case 2: {
			update();
			break;
		}
		case 3: {
			delete();
			break;
		}
		case 4: {
			get();
			break;
		}
		case 5:{
			getById();
			break;
		}
		default: {
			System.out.println("Incorrect options");
		}
		}

		// adding employees
//		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
//        Employee employee = new Employee(1, "Agnes", "a@gmail.com");
//        dao.addEmployee(employee);

		// adding employees manually

//		Scanner sc=new Scanner(System.in);
//		System.out.print("enter empid:");
//		int id=sc.nextInt();
//		
//		System.out.print("enter name:");
//		String  name=sc.next();
//		
//		System.out.print("enter email:");
//		String  email=sc.next();
//		
//		Employee employee=new Employee(id,name,email);
//		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
//		dao.addEmployee(employee);

		// list of employees

//		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
//		 List<Employee> list  = dao.getEmployees();
//		for (Employee emp : list) {
//		    System.out.println(emp.toString());
//		}

		// delete employee
//		Employee employee=new Employee();
//	    EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
//		dao.deleteEmployee(employee);
//		

//		Employee employee=new Employee();
//	    EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
//		dao.updateEmployee(employee);

//        List<Employee> list =  dao.getEmployees();
//        for (Employee emp:list) {
//            System.out.println(emp.toString());
	}

	private static void insert() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter empid:");
		int id = sc.nextInt();

		System.out.print("enter name:");
		String name = sc.next();

		System.out.print("enter email:");
		String email = sc.next();

		Employee employee = new Employee(id, name, email);
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		dao.addEmployee(employee);
//		
	}

	private static void update() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter empid:");
		int id = sc.nextInt();

		System.out.print("enter name:");
		String name = sc.next();

		System.out.print("enter email:");
		String email = sc.next();
		
		Employee employee = new Employee(id,name,email);
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		dao.updateEmployee(employee);

	}

	private static void delete() throws SQLException{
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		dao.deleteEmployee(1);
	}
private static void getById() throws SQLException{
	EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
	Employee employee=dao.getEmployeeById(2);
	System.out.println(employee);
	
}
	private static void get() throws SQLException {

		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		List<Employee> list = dao.getEmployees();
		for (Employee emp : list) {
			System.out.println(emp.toString());
		}
	}

}
