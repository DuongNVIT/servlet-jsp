package com.duongnv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.duongnv.dao.IUserDao;
import com.duongnv.model.RoleModel;
import com.duongnv.model.UserModel;

public class UserDao extends AbstractDao implements IUserDao {

	@Override
	public UserModel findByUsernamePassWordStatus(String username, String password, Integer status) {
		// TODO Auto-generated method stub
		StringBuilder sqlString = new StringBuilder("select * from user as u");
		sqlString.append(" inner join role as r on u.roleid = r.id");
		sqlString.append(" where u.username = ? and u.password = ? and u.status = ?");
		Connection connection = getConnection();
		PreparedStatement sttm = null;
		ResultSet resultSet = null;
		UserModel userModel = null;
		try {
			sttm = connection.prepareStatement(sqlString.toString());
			sttm.setString(1, username);
			sttm.setString(2, password);
			sttm.setInt(3, status);
			resultSet = sttm.executeQuery();
			while(resultSet.next()) {
				userModel = new UserModel();
				userModel.setId(resultSet.getLong("id"));
				userModel.setUsername(resultSet.getString("username"));
				userModel.setPassword(resultSet.getString("password"));
				userModel.setFullname(resultSet.getString("fullname"));
				RoleModel roleModel = new RoleModel();
				roleModel.setName(resultSet.getString("name"));
				roleModel.setCode(resultSet.getString("code"));
				userModel.setRoleModel(roleModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userModel;
	}
	
}
