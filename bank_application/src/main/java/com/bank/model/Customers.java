package com.bank.model;


import java.util.Date;

public class Customers {
	private int id;
	private long contact;
	private String name, gender, address, city, state, email;
	private Date dob;
	
	public Customers() {
		//constructor
	}

	public Customers(int id, long contact, String name, String gender, String address, String city,
			String state, String email, Date dob) {
		super();
		this.id = id;
		this.contact = contact;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer [ID = " +id+", Name = "+name+", Gender = "+gender+", dob = "+dob+", Contact = "+contact+", Email = "+email
				+", Address= "+address+", "+ city +", "+state+" ]";
	}
	
	
}
