package com.github.dcoric.demonico.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	private User user;
	
	@Autowired(required=true)
	private UserService userService;
	
	public MainController() {
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		log.info(":> Pocetna strana.");
		return execute(model);
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String insertUser(ModelMap model, 
			@RequestParam(required=true) String username,
			@RequestParam(required=true) String password, 
			@RequestParam(required=false) String birthDate, 
			@RequestParam(required=false) String firstName, 
			@RequestParam(required=false) String lastName) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
		Date date = new Date();
		try {
			date = formatter.parse(birthDate);
		} catch (ParseException e) {
			log.warn("Pogresan format. Pokusavam alternativni format!");
			formatter = new SimpleDateFormat("dd/mm/yyyy");
			try {
				date = formatter.parse(birthDate);
			} catch (ParseException e1) {
				log.warn("Pogresan format! Odustajem! greska: " + e1);
				
			}
		}
		log.info(";> birthDate: " + date);
		User user = setUserData(username, password, firstName, lastName,
				date);
		if(userService.findUserByUsername(username) == null){
			userService.persistUser(user);
			log.info(":> User sacuvan!");
			model.addAttribute("success", true);
		}
		
		model.addAttribute(user);
		
		return execute(model);
	}
	
	@RequestMapping(value = "/viewUsers", method = RequestMethod.GET)
	public String viewAllUsers(ModelMap model) {
		
		List<User> allUsers = userService.findAll();
		log.info(":> User list: " + allUsers.size());
		model.addAttribute("allUsers", allUsers);
		return execute(model);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String userAddForm(ModelMap model) {
		log.info("Inicijalizovano dodavanje korisnika");
		model.addAttribute("addUser", true);
		return execute(model);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userAddForm(ModelMap model,
			@RequestParam(required=true) String username,
			@RequestParam(required=true) String password ) {
		user = userService.findUserUsernamePassword(username, password);
		log.info("Korisnik " + username + (user!=null?" se uspesno ulogovao":" se nije ulogovao zbog pogresnog username/password-a!"));
		model.addAttribute("errorMessage", "Pogresan username ili password!");
		return execute(model);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		user = null;
		
		return execute(model);
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
	
	private String execute(ModelMap model) {
		if(user!=null) {
			model.addAttribute(user);
			model.addAttribute("title", "Home page");
		}
		return "index";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
