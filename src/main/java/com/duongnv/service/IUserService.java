package com.duongnv.service;

import com.duongnv.model.UserModel;

public interface IUserService {
	UserModel findByUsernamePassWordStatus(String username, String password, Integer status);
}
