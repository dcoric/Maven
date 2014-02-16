package com.github.dcoric.demonico.dao;

import java.util.List;

import com.github.dcoric.demonico.model.User;

public interface UserDAO {
	
	public void persistUser(User user);
	
	public User findUserById(Integer id);
	
	public User findUserUsernamePassword(String username, String password);
	
	public List<User> findAll();
	
	public List<User> findUserByName(String firstName, String lastName);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);

	public User findUserByUsername(String username);

}
