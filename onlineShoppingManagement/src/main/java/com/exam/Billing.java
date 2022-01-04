package com.exam;

import java.sql.Date;

public class Billing {
	int id;
	String firstName;
	String lastName;
	String form14;
	String form15;
	String postcode;
	String city;
	String phone;
	String email;
	String form76;
	double total;
	Date currentDate;
	Date expectedDate;
	
	
	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Billing(String firstName, String lastName, String form14, String form15, String postcode, String city,
			String phone, String email, String form76, double total, Date currentDate, Date expectedDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.form14 = form14;
		this.form15 = form15;
		this.postcode = postcode;
		this.city = city;
		this.phone = phone;
		this.email = email;
		this.form76 = form76;
		this.total = total;
		this.currentDate = currentDate;
		this.expectedDate = expectedDate;
	}


	public Billing(int id, String firstName, String lastName, String form14, String form15, String postcode,
			String city, String phone, String email, String form76, double total, Date currentDate, Date expectedDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.form14 = form14;
		this.form15 = form15;
		this.postcode = postcode;
		this.city = city;
		this.phone = phone;
		this.email = email;
		this.form76 = form76;
		this.total = total;
		this.currentDate = currentDate;
		this.expectedDate = expectedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getForm14() {
		return form14;
	}
	public void setForm14(String form14) {
		this.form14 = form14;
	}
	public String getForm15() {
		return form15;
	}
	public void setForm15(String form15) {
		this.form15 = form15;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getForm76() {
		return form76;
	}
	public void setForm76(String form76) {
		this.form76 = form76;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	
	
	

}
