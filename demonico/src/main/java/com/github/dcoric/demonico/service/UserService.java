package com.github.dcoric.demonico.service;

import java.util.List;

import com.github.dcoric.demonico.model.User;

public interface UserService {
	
	public void persistUser(User user);
	
	public User findUserById(Integer id);
	
	public List<User> findUserByName(String firstName, String lastName);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);

	public User findUserByUsername(String username);
}
