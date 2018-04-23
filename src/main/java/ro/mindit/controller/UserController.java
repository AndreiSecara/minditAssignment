package ro.mindit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.mindit.model.User;
import ro.mindit.service.UserService;


@Controller
@RequestMapping(value = "/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView(); 
		model.addObject("user", new User());
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value="/loginError", method=RequestMethod.GET)
	public ModelAndView loginError() {
		return new ModelAndView("loginError");
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		model.addObject("user", new User());
		model.setViewName("signup");
		return model;
	}
	
	@RequestMapping(value = "/login/confirm", method = RequestMethod.POST)
	public String loginConfirm(@ModelAttribute("user") User user) {
		if(userService.userExists(user.getUser_name(), user.getPassword())) {
			return "redirect:/forums";
		}
		else {
			return "redirect:/loginError";
		}
	}
			
	@RequestMapping(value = "/signup/confirm", method = RequestMethod.POST)
	public String signupConfirm(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/welcome";
	}
}
