package org.gpi.asosegur.controller;

import org.gpi.asosegur.dto.UserRegistrationDTO;
import org.gpi.asosegur.mode.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	 private UserService userService;

	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}
	@ModelAttribute("user")
	public UserRegistrationDTO userRegistrationDTO() {
		return new UserRegistrationDTO()  ;
		
	}
	
	@GetMapping
	public String registrationForm() {
		return "/users/registration";	
	}
//	@GetMapping("/login")
//	public String login() {
//		return "/users/login";
//	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user")  UserRegistrationDTO registrationDTO) {
	
		userService.save(registrationDTO);
		return "redirect:/registration?success ";
	}
	

}
