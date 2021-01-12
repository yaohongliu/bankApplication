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

	public int getemployeeId() {
		return employeeId;
	}

	public void setemployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getemployeeName() {
		return employeeName;
	}

	public void setemployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getemployeeEmail() {
		return employeeEmail;
	}

	public void setemployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getemployeeUserName() {
		return employeeUserName;
	}

	public void setemployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}

	public String getemployeePassword() {
		return employeePassword;
	}

	public void setemployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee [ID = " + employeeId + ", Name = " + employeeName + ", Email = "
				+ employeeEmail + ", login = " + employeeUserName + ", password = " + employeePassword + " ]";
	}

}
