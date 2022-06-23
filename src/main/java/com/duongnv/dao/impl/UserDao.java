package com.duongnv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.duongnv.dao.IUserDao;
import com.duongnv.model.UserModel;

public class UserDao extends AbstractDao implements IUserDao {

	@Override
	public UserModel findByUsernamePassWordStatus(String username, String password, Integer status) {
		// TODO Auto-generated method stub
		StringBuilder sqlString = new StringBuilder("select * from user as u");
		sqlString.append(" inner joint role as r on u.roleid = r.id");
		sqlString.append(" where u.username = ? and u.password = ? and u.status = ?");
		Connection connection = getConnection();
		PreparedStatement sttm = null;
		try {
			sttm = connection.prepareStatement(sqlString.toString());
			sttm.setString(1, username);
			sttm.setString(2, password);
			sttm.setInt(3, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
