package com.github.dcoric.demonico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.dcoric.demonico.dao.UserDAO;
import com.github.dcoric.demonico.model.User;
import com.github.dcoric.demonico.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;
	
	@Transactional
	public void persistUser(User user) {
		userDAO.persistUser(user);
	}

	@Transactional
	public User findUserById(Integer id) {
		return userDAO.findUserById(id);
	}

	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Transactional
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

}
