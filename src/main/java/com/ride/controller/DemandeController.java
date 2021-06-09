package com.ride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ride.model.Demande;
import com.ride.model.User;
import com.ride.service.DemandeService;
import com.ride.service.UserService;
import com.sun.el.stream.Optional;

@Controller
public class DemandeController {
	@Autowired
	private DemandeService ds;
	@Autowired
	private UserService us;
	
	@GetMapping("/mesdemandes")
	public String viewClientDemandes(Model model, Long id) {
		id=1l;
		model.addAttribute("demandes", ds.getDemandes(id));
		System.out.println(ds.getDemandes(id).size());
		return "mesdemandes";
	}
	
	@GetMapping("/nvdemande")
	public String afficherDemande(Model model) {
		Demande demande = new Demande();
		model.addAttribute("demande", demande);

		return "nvdemande";
	}
	
	@GetMapping("/mesinfos")
	public String afficherInfos(Model model) {
		java.util.Optional<User> user = us.getUserById(1l);
		model.addAttribute("user", user.get());
		
		model.addAttribute("total", ds.getDemandes(1l).size());
		return "mesinfos";
	}
	
	@PostMapping("/add_demande")
	public String ajouterDemande(@ModelAttribute("demande") Demande demande) {
	    float prix=200;
		demande.setEtat("NV");
		demande.setId_client(1l);
		if (demande.getChaise()==1) {
			prix+=30;
		}
		if (demande.getWifi()==1) {
			prix+=10;
		}
		demande.setPrix(prix);
		
		if (demande.getChaise()!=1) {
			demande.setChaise(0);
		}
		if (demande.getWifi()!=1) {
			demande.setWifi(0);
		}
		ds.insertDemande(demande);

		return "redirect:/mesdemandes";
	}
	
}
