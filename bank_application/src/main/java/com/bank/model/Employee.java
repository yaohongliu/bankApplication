package com.bank.model;

public class Employee {

	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeeUserName;
	private String employeePassword;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String employeeName, String employeeEmail, String employeeUserName,
			String employeePassword) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeUserName = employeeUserName;
		this.employeePassword = employeePassword;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getemployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getemployeeUsername() {
		return employeeUserName;
	}

	public void setEmployeeUsername(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee [ID = " + employeeId + ", Name = " + employeeName + ", Email = "
				+ employeeEmail + ", login = " + employeeUserName + ", password = " + employeePassword + " ]";
	}

}
