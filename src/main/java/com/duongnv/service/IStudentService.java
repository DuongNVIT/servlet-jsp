package com.duongnv.service;

import java.util.List;

import com.duongnv.model.StudentModel;

public interface IStudentService {
	List<StudentModel> findAll();
	StudentModel save(StudentModel studentModel);
	void delete(Long studentId);
	StudentModel findById(Long studentId);
	void update(StudentModel studentModel);
}
