package com.duongnv.model;

import java.sql.Timestamp;

public class AbstractModel<T> {
	private long id;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String createdBy;
	private String modifiedBy;
	
	
	public AbstractModel() {
		super();
	}


	public AbstractModel(Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy) {
		super();
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	public Timestamp getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
}
