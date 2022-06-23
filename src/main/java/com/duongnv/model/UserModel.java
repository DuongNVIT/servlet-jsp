package com.duongnv.model;

public class UserModel extends AbstractModel<UserModel>{
	private String username;
	private String password;
	private int status;
	private long roleid;
	private RoleModel roleModel = new RoleModel();
	
	public UserModel() {
		super();
	}

	public UserModel(String username, String password, int status, int roleid, RoleModel roleModel) {
		super();
		this.username = username;
		this.password = password;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}
}
