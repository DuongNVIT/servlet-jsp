package com.duongnv.dao;

import com.duongnv.model.UserModel;

public interface IUserDao {
	UserModel findByUsernamePassWordStatus(String username, String password, Integer status);
}
