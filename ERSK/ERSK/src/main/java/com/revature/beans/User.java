package com.revature.beans;

public class User {
	private String firstName;
	private String lastName;
	private int userId;
	
	public User() {}
	
	public User(String firstName, String lastName, int userId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.setUserId(userId);
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
