package com.duongnv.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AbstractDao {
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String urlString = resourceBundle.getString("url");
			String username = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(urlString, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
