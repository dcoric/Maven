package com.github.dcoric.demonico.dao;

import com.github.dcoric.demonico.model.User;

public interface UserDAO {
	
	void persistUser(User user);
	
	User findUserById(Integer id);
	
	void updateUser(User user);
	
	void deleteUser(User user);

}
