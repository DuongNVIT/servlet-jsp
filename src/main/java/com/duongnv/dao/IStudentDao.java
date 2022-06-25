package com.duongnv.dao;

import java.util.List;

import com.duongnv.model.StudentModel;

public interface IStudentDao {
	List<StudentModel> findAll();
	StudentModel save(StudentModel studentModel);
	void delete(Long studentId);
	StudentModel findById(Long studentId);
	void update(StudentModel studentModel);
}
