package com.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.bytebuddy.matcher.ModifierMatcher.Mode;
@Controller
public class AppController {
	@Autowired
    private UserRepository repo;
	@GetMapping("")
	public String viewHomePage(){
		return "index";
	}
	@GetMapping("/acceuil_admin")
	public String viewAdminHomePage(){
		return "acceuilA";
	}
	@GetMapping("/acceuil_client")
	public String viewClientHomePage(){
		return "acceuilC";
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
	@PostMapping("/process_signup")
	public String processSignUp(User user) {
		User existing = repo.findByEmail(user.getEmail());
        if (existing != null){
            return "redirect:/inscription?error";
        }
        else {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String encodedPassword=encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "redirect:/connexion?success";
        }
	}
	
	
	
}
