package com.vicky.entity;

public class FeedBackEntity {
	
	private int id;
	private String name;
	private String mobileNo;
	private String message;
	
	public FeedBackEntity(int id, String name, String mobileNo, String message) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "FeedBackEntity [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", message=" + message + "]";
	}
	
	
	

}
