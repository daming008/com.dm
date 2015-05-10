package com.dm.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dm.model.User;
import com.dm.util.DbUtils;

public class UserDAO implements IUserDAO {

	@Override
	public void add(User user) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String sql = "insert into t_user(username,password,nickname) values(?,?,?)";
		try {
			connection = DbUtils.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setString(3, user.getNickname());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.close(prepareStatement);
			DbUtils.close(connection);
		}
		
	}

	@Override
	public void delete(String username) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String sql = "delete from t_user where username=?";
		try {
			connection = DbUtils.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, username);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.close(prepareStatement);
			DbUtils.close(connection);
		}
	}

	@Override
	public User load(String username) {
		User u = null;
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		String sql = "select * from t_user where username=?";
		try {
			connection = DbUtils.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, username);
			rs = prepareStatement.executeQuery();
			while(rs.next()){
				if(u == null) u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setNickname(rs.getString("nickname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.close(rs);
			DbUtils.close(prepareStatement);
			DbUtils.close(connection);
		}
		return u;
	}

}
