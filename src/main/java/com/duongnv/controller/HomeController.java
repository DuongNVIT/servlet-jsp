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
@WebServlet(urlPatterns = { "/login" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	@Inject
	private UserService userService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		if (message != null && !message.equals("")) {
			request.setAttribute("message", resourceBundle.getString(message));
			request.setAttribute("alert", alert);
		}
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String nameString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		UserModel userModel = userService.findByUsernamePassWordStatus(nameString, passwordString, 1);
		if (userModel != null) {
			SessionUtil.getInstance().putValue(request, "USERMODEL", userModel);
			request.setAttribute("USERMODEL", userModel);
			response.sendRedirect(request.getContextPath() + "/student?action=list");
			// response.sendRedirect(request.getContextPath() + "/student?action=list");
			// request.getRequestDispatcher("views/student-list.jsp").forward(request,
			// response);
			// request.getRequestDispatcher("views/upload.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/login?message=incorrect&alert=fail");
		}

	}
}
