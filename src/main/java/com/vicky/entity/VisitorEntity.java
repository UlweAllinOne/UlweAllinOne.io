package com.vicky.entity;

public class VisitorEntity {
	
	private int id;
	private String flatno;
	private String phoneno;
	private String comment;
	private String datetime;
	
	
	public VisitorEntity(int id, String flatno, String phoneno, String comment, String datetime) {
		super();
		this.id = id;
		this.flatno = flatno;
		this.phoneno = phoneno;
		this.comment = comment;
		this.datetime = datetime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlatno() {
		return flatno;
	}
	public void setFlatno(String flatno) {
		this.flatno = flatno;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "VisitorEntity [id=" + id + ", flatno=" + flatno + ", phoneno=" + phoneno + ", comment=" + comment
				+ ", datetime=" + datetime + "]";
	}
	

}
