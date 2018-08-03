package com.revature.beans;

import java.sql.Blob;

public class Image {
	private int imageId;
	private String image;
	private int reimburseId;
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(int imageId, String image, int reimburseId) {
		super();
		this.imageId = imageId;
		this.image = image;
		this.reimburseId = reimburseId;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getReimburseId() {
		return reimburseId;
	}
	public void setReimburseId(int reimburseId) {
		this.reimburseId = reimburseId;
	}
	
	
}