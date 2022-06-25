package com.duongnv.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.duongnv.dao.impl.StudentDao;
import com.duongnv.model.StudentModel;
import com.duongnv.service.IStudentService;

public class StudentService implements IStudentService {
	
	@Inject
	private StudentDao studentDao;

	public List<StudentModel> findAll() {
		return studentDao.findAll();
	}

	public StudentModel save(StudentModel studentModel) {
		return studentDao.save(studentModel);
	}

	@Override
	public void delete(Long studentId) {
		studentDao.delete(studentId);
	}

	@Override
	public StudentModel findById(Long studentId) {
		return studentDao.findById(studentId);
	}

	@Override
	public void update(StudentModel studentModel) {
		studentDao.update(studentModel);
	}

}
