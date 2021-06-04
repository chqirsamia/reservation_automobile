package com.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.bytebuddy.matcher.ModifierMatcher.Mode;
@Controller
public class AppController {
	@Autowired
    private UserRepository userRepo;
	@GetMapping("")
	public String viewHomePage(){
		return "index";
	}
	@GetMapping("/connexion")
	public String showSignInForm(Model model) {
		model.addAttribute("user",new User());
		return "signin";
	}
	@GetMapping("/inscription")
	public String showSignUpForm(Model model) {
		model.addAttribute("user",new User());
		return "signup";
	}
	
}
