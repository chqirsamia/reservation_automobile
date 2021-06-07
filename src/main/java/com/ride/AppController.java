package com.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.model.Demande;
import com.ride.User;
import com.ride.UserRepository;
import com.ride.voiture.Voiture;

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
	@GetMapping("/acceuilA")
	public String showHome() {
		return "acceuilA";
	}
	
	@GetMapping("/user-list")
	public String showAdmin(Model model) {
		model.addAttribute("user",new User());
		return "user-list";
	}
	@GetMapping("/ShowDemandeT")
	public String showDemande(Model model) {
		model.addAttribute("demande",new Demande());
		return "list-demande";
	}
	
	@GetMapping("/newVoiture")
	public String newVoiture(Model model) {
		model.addAttribute("voiture",new Voiture());
		
		return "addVoiture";
	}

	}

	

