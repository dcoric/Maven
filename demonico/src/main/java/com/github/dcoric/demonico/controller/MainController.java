package com.github.dcoric.demonico.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		user.setFirstName("Denis");
		user.setInsertionDate(Calendar.getInstance().getTime());
		model.addAttribute(user);
		return "index";
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String insertUser(ModelMap model, 
			@RequestParam(required=true) String username,
			@RequestParam(required=true) String password, 
			@RequestParam(required=false) String birthDate, 
			@RequestParam(required=false) String firstName, 
			@RequestParam(required=false) String lastName) {
		log.info(";> TEST!");
		log.info("'> username: " + username);
		log.info(";> password: " + password);
		log.info(":> firstName: " + firstName);
		log.info("'> lastName: " + lastName);
		SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
		Date date = new Date();
		try {
			date = formatter.parse(birthDate);
		} catch (ParseException e) {
			log.warn(e);
		}
		log.info(";> birthDate: " + date);
		User user = setUserData(username, password, firstName, lastName,
				date);
		if(userService.findUserByUsername(username) == null){
			userService.persistUser(user);
			model.addAttribute("success", true);
		}
		
		model.addAttribute(user);
		
		return "index";
	}

	private User setUserData(String username, String password,
			String firstName, String lastName, Date birthDate) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setBirthDate(birthDate);
		user.setInsertionDate(new Date());
		return user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
