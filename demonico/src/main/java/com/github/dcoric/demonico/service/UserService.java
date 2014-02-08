package com.github.dcoric.demonico.service;

import com.github.dcoric.demonico.model.User;

public interface UserService {
	
	public void persistUser(User user);
	
	public User findUserById(Integer id);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
}
