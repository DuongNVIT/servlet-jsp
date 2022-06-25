package com.duongnv.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duongnv.model.StudentModel;
import com.duongnv.model.UserModel;
import com.duongnv.service.impl.StudentService;
import com.duongnv.service.impl.UserService;
import com.duongnv.utils.SessionUtil;

/**
 * Servlet implementation class StudentController
 */
@WebServlet(urlPatterns = { "/student" })
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private StudentService studentService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(33);
		String action = request.getParameter("action");
		
		if (action != null && action.equals("add")) {
			request.getRequestDispatcher("/views/add-student.jsp").forward(request, response);
		} else if(action != null && action.equals("list")){
			List<StudentModel> studentModels = studentService.findAll();
			request.setAttribute("students", studentModels);
			request.getRequestDispatcher("views/student-list.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String className = request.getParameter("class");
		StudentModel studentModel = new StudentModel();
		studentModel.setFullName(fullname);
		studentModel.setEmail(email);
		studentModel.setClassName(className);
		studentModel.setCreatedBy(((UserModel) (SessionUtil.getInstance().getValue(request, "USERMODEL"))).getUsername());
		studentModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		studentModel = studentService.save(studentModel);
		response.sendRedirect(request.getContextPath() + "/student?action=list");
	}
}
