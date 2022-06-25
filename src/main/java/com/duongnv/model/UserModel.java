package com.duongnv.model;

public class UserModel extends AbstractModel<UserModel>{
	private String username;
	private String password;
	private String fullname;
	private int status;
	private long roleid;
	private RoleModel roleModel = new RoleModel();
	
	public UserModel() {
		super();
	}

	public UserModel(String username, String password, String fullname, int status, long roleid, RoleModel roleModel) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.status = status;
		this.roleid = roleid;
		this.roleModel = roleModel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

	
	
	
}