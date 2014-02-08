package com.github.dcoric.demonico.controller;

import java.util.Calendar;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.dcoric.demonico.model.User;
import com.github.dcoric.demonico.service.UserService;

@Controller
@Scope("session")
public class MainController {
	
	private static Logger log = Logger.getLogger(MainController.class);
	
	@Autowired(required=true)
	private UserService userService;
	
	public MainController() {
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		log.info("Welcome!");
		User user = new User();
		setTestData(user);
		user.setInsertionDate(Calendar.getInstance().getTime());
		model.addAttribute(user);
		return "index";
	}
	
	@RequestMapping(value = "/insertUser", method = RequestMethod.GET)
	public String insertUser(ModelMap model) {
		log.info("Create new!");
		User user = new User();
		setTestData(user);
		user.setInsertionDate(Calendar.getInstance().getTime());
		userService.persistUser(user);
		model.addAttribute(user);
		return "index";
	}

	private void setTestData(User user) {
		user.setFirstName("Denis");
		user.setLastName("Æoriæ");
		user.setUsername("denis.coric");
		user.setPassword("test123");
		Calendar cal  = Calendar.getInstance();
		cal.set(1985, 12, 27, 19, 15);
		user.setBirthDate(cal.getTime());
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
