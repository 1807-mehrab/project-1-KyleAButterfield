package com.revature.beans;

public class Admin {
	private String firstName;
	private String lastName;
	private int adminId;
	
	public Admin() {}
	
	public Admin(String firstName, String lastName, int adminId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminId = adminId;
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
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getAdminId() {
		return adminId;
	}
}
