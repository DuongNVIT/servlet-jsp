package com.duongnv.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.duongnv.dao.impl.UserDao;
import com.duongnv.model.StudentModel;
import com.duongnv.model.UserModel;
import com.duongnv.service.IUserService;

public class UserService implements IUserService {
	
	@Inject
	private UserDao userDao;

	@Override
	public UserModel findByUsernamePassWordStatus(String username, String password, Integer status) {
		// TODO Auto-generated method stub
		//userDao = new UserDao();
		UserModel userModel = userDao.findByUsernamePassWordStatus(username, password, status);
		return userModel;
	}

}
