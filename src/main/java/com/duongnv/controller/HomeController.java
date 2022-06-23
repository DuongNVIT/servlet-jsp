package com.duongnv.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duongnv.model.UserModel;
import com.duongnv.utils.SessionUtil;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/login")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		
		
		if(nameString.equals("duong") && passwordString.equals("123")) {
			UserModel userModel = new UserModel();
			SessionUtil.getInstance().putValue(request, "USERMODEL", userModel);
			response.sendRedirect("views/student-list.jsp");
		}
		
		
	}
}
