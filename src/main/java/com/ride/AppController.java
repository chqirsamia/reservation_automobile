package com.ride;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Demande;
import com.ride.User;
import com.ride.UserRepository;
import com.ride.voiture.Voiture;
import com.ride.voiture.VoitureService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;
@Controller
public class AppController {
	@Autowired
    private UserRepository userRepo;
	private final UserService  UserService ;
	public AppController(UserService UserService) {
		this.UserService=UserService;
	}
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
		model.addAttribute("list", UserService.getAdmins());
		
		return "user-list";
	}
	
	@GetMapping("/user-list/newAdmin")
	public String newAdmin(Model model) {
		model.addAttribute("user",new User());
		
		return "user-form";
	}
	
	@PostMapping(path="/user-list/insertAdmin")
	public String insertNewAdmin(@Valid User user, BindingResult result,Model model)
	{UserService.addNewAdmin(user);
	return "redirect:/user-list";}
	
	@GetMapping (path="/editAdmin/{AdminID}")
	public String editAdmin(@PathVariable Long AdminID,Model model) {
		User admin=UserService.getAdmin(AdminID);
		
		model.addAttribute("user",admin);
		return "user-edit";
	}
	
	
	@PostMapping (path="/admins/update/{id}")
	public String updateUser (@PathVariable Long id,@RequestParam(required=false) String tel,
			@RequestParam(required=false) String email) {
		UserService.updateAdmin(email,tel,id);
		return "redirect:/user-list";}
	
	@GetMapping(path="/admins/delete/{id}")
	public String deleteAdmin(@PathVariable("id") Long id) {
		UserService.deleteUser(id);
		return "redirect:/user-list";}
	
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

	

