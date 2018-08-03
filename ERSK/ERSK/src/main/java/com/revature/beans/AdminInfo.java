package com.revature.beans;

public class AdminInfo {
	private String Address;
	private long Phone;
	private int adminID;
	
	public AdminInfo() {}
	
	public AdminInfo(String address, long phone2, int adminID) {
		super();
		Address = address;
		Phone = phone2;
		this.adminID = adminID;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
}
