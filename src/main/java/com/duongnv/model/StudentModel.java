package com.duongnv.model;

public class StudentModel extends AbstractModel<StudentModel>{
	
	private String fullName;
	private String email;
	
	
	public StudentModel() {
		super();
	}
	public StudentModel(String fullName, String email) {
		super();
		this.fullName = fullName;
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
