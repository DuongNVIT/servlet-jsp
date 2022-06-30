package com.duongnv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.duongnv.dao.IStudentDao;
import com.duongnv.model.StudentModel;

public class StudentDao extends AbstractDao implements IStudentDao {

	@Override
	public List<StudentModel> findAll() {
		List<StudentModel> studentModels = new ArrayList<>();
		StringBuilder sql = new StringBuilder("select * from student");
		Connection connection = getConnection();
		PreparedStatement sttm = null;
		ResultSet resultSet = null;
		try {
			sttm = connection.prepareStatement(sql.toString());
			resultSet = sttm.executeQuery();
			while (resultSet.next()) {
				StudentModel studentModel = new StudentModel();
				studentModel.setId(resultSet.getLong("id"));
				studentModel.setFullName(resultSet.getString("fullname"));
				studentModel.setEmail(resultSet.getString("email"));
				studentModel.setClassName(resultSet.getString("class"));
				studentModel.setCreatedBy(resultSet.getString("createdby"));
				studentModel.setCreatedDate(resultSet.getTimestamp("createddate"));
				studentModel.setModifiedBy(resultSet.getString("modifiedby"));
				studentModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
				studentModels.add(studentModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return studentModels;
		}
	}

	@Override
	public StudentModel save(StudentModel studentModel) {
		StringBuilder sql = new StringBuilder("insert into student(fullname, email, class, createdby, createddate, avatar) ");
		sql.append("values (?, ?, ?, ?, ?, ?)");
		Connection connection = getConnection();
		PreparedStatement sttm = null;
		ResultSet resultSet = null;
		try {
			sttm = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			sttm.setString(1, studentModel.getFullName());
			sttm.setString(2, studentModel.getEmail());
			sttm.setString(3, studentModel.getClassName());
			sttm.setString(4, studentModel.getCreatedBy());
			sttm.setTimestamp(5, studentModel.getCreatedDate());
			sttm.setString(4, studentModel.getAvatar());
			sttm.executeUpdate();
			resultSet = sttm.getGeneratedKeys();
			while (resultSet.next()) {
				studentModel.setId(resultSet.getLong(1));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return studentModel;
		}
	}

	@Override
	public void delete(Long studentId) {
		StringBuilder sql = new StringBuilder("delete from student where id = ?");
		Connection connection = getConnection();
		PreparedStatement sttm = null;
		try {
			sttm = connection.prepareStatement(sql.toString());
			sttm.setLong(1, studentId);
			sttm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public StudentModel findById(Long studentId) {
		StringBuilder sql = new StringBuilder("select * from student where id = ?");
		Connection connection = getConnection();
		PreparedStatement sttm = null;
		ResultSet resultSet = null;
		StudentModel studentModel = null;
		try {
			sttm = connection.prepareStatement(sql.toString());
			sttm.setLong(1, studentId);
			resultSet = sttm.executeQuery();
			while (resultSet.next()) {
				studentModel = new StudentModel();
				studentModel.setId(resultSet.getLong("id"));
				studentModel.setFullName(resultSet.getString("fullname"));
				studentModel.setEmail(resultSet.getString("email"));
				studentModel.setClassName(resultSet.getString("class"));
				studentModel.setCreatedBy(resultSet.getString("createdby"));
				studentModel.setCreatedDate(resultSet.getTimestamp("createddate"));
				studentModel.setModifiedBy(resultSet.getString("modifiedby"));
				studentModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return studentModel;
		}
	}

	@Override
	public void update(StudentModel studentModel) {
		StringBuilder sql = new StringBuilder();
		sql.append("update student set fullname = ?, email = ?, class = ?, createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? where id = ?");
		Connection connection = getConnection();
		PreparedStatement sttm = null;
		try {
			sttm = connection.prepareStatement(sql.toString());
			sttm.setString(1, studentModel.getFullName());
			sttm.setString(2, studentModel.getEmail());
			sttm.setString(3, studentModel.getClassName());
			sttm.setTimestamp(4, studentModel.getCreatedDate());
			sttm.setString(5, studentModel.getCreatedBy());
			sttm.setTimestamp(6, studentModel.getModifiedDate());
			sttm.setString(7, studentModel.getModifiedBy());
			sttm.setLong(8, studentModel.getId());
			sttm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
