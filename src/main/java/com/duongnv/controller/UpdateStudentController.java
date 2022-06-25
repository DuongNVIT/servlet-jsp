package com.duongnv.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duongnv.model.StudentModel;
import com.duongnv.model.UserModel;
import com.duongnv.service.impl.StudentService;
import com.duongnv.utils.SessionUtil;

/**
 * Servlet implementation class EditStudentController
 */
@WebServlet("/updateStudent")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private StudentService studentService;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		System.out.println(27 + " " + idString);
		Long studentId = Long.parseLong(request.getParameter("id"));
		StudentModel studentModel = studentService.findById(studentId);
		request.setAttribute("student", studentModel);
		request.getRequestDispatcher("/views/add-student.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Long studentId = Long.parseLong(request.getParameter("id"));
		System.out.println(39 + " " + studentId);
		StudentModel studentModel = studentService.findById(studentId);
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String className = request.getParameter("class");
		studentModel.setFullName(fullname);
		studentModel.setEmail(email);
		studentModel.setClassName(className);
		studentModel.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUsername());
		studentModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		studentService.update(studentModel);
		response.sendRedirect(request.getContextPath() + "/student?action=list");
	}

}
