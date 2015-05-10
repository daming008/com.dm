package com.dm.dao;

import com.dm.model.User;

public interface IUserDAO {
	public void add(User user);
	
	public void delete(String username);
	
	public User load(String username);
	
}
