package com.ride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ride.model.User;
import com.ride.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/add_user")
	public String showinfos(@ModelAttribute("user") User user, Model model) {
		User u = userservice.getUserById(1l).get();
		user.setPassword(u.getPassword());
		user.setRole(u.getRole());
		user.setId(u.getId());
		userservice.insertUser(user);
		
		String etat="V";
		model.addAttribute("etat", etat);
		return "redirect:/mesinfos";
	}
}
