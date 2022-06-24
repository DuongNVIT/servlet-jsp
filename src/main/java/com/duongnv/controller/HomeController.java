package com.duongnv.controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duongnv.model.UserModel;
import com.duongnv.service.impl.UserService;
import com.duongnv.utils.SessionUtil;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/login")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	@Inject 
	private UserService userService;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		System.out.println(33 + " " + alert);
		if(message != null && !message.equals("")) {
			request.setAttribute("message", resourceBundle.getString(message));
			request.setAttribute("alert", alert);
		}
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		
		//userService = new UserService();
		//UserModel userModel = null;
		UserModel userModel	= userService.findByUsernamePassWordStatus(nameString, passwordString, 1);
		
		if(userModel != null) {
			SessionUtil.getInstance().putValue(request, "USERMODEL", userModel);
			response.sendRedirect(request.getContextPath() + "/student-list");
			//request.getRequestDispatcher("/student-list").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/login?message=incorrect&alert=fail");
			System.out.println("Tên đăng nhập hoặc mk không đúng");
		}
		
	}
}
