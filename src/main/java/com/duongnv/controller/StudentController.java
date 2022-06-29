package com.duongnv.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.duongnv.model.StudentModel;
import com.duongnv.model.UserModel;
import com.duongnv.service.impl.StudentService;
import com.duongnv.utils.SessionUtil;

/**
 * Servlet implementation class StudentController
 */
@MultipartConfig()
@WebServlet(urlPatterns = { "/student" })
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "uploads";
	
	@Inject
	private StudentService studentService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		StudentModel studentModel = new StudentModel();
		studentModel.setFullName(request.getParameter("fullname"));
		studentModel.setEmail(request.getParameter("email"));
		studentModel.setClassName(request.getParameter("class"));
		studentModel.setCreatedBy(((UserModel) (SessionUtil.getInstance().getValue(request, "USERMODEL"))).getUsername());
		studentModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		
		String applicationPath = request.getServletContext().getRealPath("");
		System.out.println(applicationPath);
		
		String uploadFilePath = null;
		if(applicationPath.endsWith("\\")) {
			uploadFilePath = applicationPath + UPLOAD_DIR;			
		} else {
			uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;	
		}
		
		System.out.println(uploadFilePath);
		
		File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
        
        String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }
		
		studentModel = studentService.save(studentModel);
		response.sendRedirect(request.getContextPath() + "/student?action=list");
	}

	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
	}
}
