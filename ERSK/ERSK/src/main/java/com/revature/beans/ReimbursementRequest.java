package com.revature.beans;

public class ReimbursementRequest {
	private int requestID;
	private String description;
	private String status;
	private double amount;
	private int userId;
	private String updater;
	
	public ReimbursementRequest() {}
	public ReimbursementRequest(int requestID,String description,String status, double amount, int userId) {
		super();
		this.requestID = requestID;
		this.description = description;
		this.status = status;
		this.amount = amount;
		this.userId = userId;
	}
	
	public ReimbursementRequest(int requestID,String description,String status, double amount, int userId, String updater) {
		super();
		this.requestID = requestID;
		this.description = description;
		this.status = status;
		this.amount = amount;
		this.userId = userId;
		this.updater = updater;
	}
	
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
}
