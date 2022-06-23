package com.duongnv.model;

public class StudentModel extends AbstractModel<StudentModel>{
	
	private String fullName;
	private String email;
	private String className;

	public StudentModel() {
		super();
	}

	public StudentModel(String fullName, String email, String className) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.className = className;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
