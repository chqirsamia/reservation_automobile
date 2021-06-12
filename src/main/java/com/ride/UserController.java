package com.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	@Autowired
	private UserRepository userrepo;
	
	@PostMapping("/add_user")
	public String showinfos(@ModelAttribute("user") User user, Model model, Authentication authentication) {
		CustomUserDetails cuser = (CustomUserDetails) authentication.getPrincipal();
		User u = userservice.getUserById(cuser.getId()).get();
		user.setPassword(u.getPassword());
		user.setRole(u.getRole());
		user.setId(u.getId());
		userservice.insertUser(user);
		
		
		return "redirect:/mesinfos";
	}
}
