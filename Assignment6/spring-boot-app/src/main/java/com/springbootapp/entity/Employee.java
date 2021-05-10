package com.springbootapp.entity;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "employees")
	public class Employee {

		private Long id;
		private String firstName;
		private String lastName;
		private String gender;
		private String email;
		
		public Employee() {
			
		}
		
		public Employee(String firstName, String lastName, String email, String gender) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.gender=gender;		}
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

				
		@Column(name = "firstName", nullable = false)
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		@Column(name = "lastName", nullable = false)
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		@Column(name = "gender", nullable = false)
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
		@Column(name = "email", nullable = false)
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		

		@Override
		public String toString() {
			return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ",gender="+gender+", email=" + email
					+ "]";
		}
		
	}

