package com.ride.demandeclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ride.CustomUserDetails;
import com.ride.User;
import com.ride.UserService;
import com.ride.demandeadmin.Demande;
import com.ride.demandeadmin.DemandeService;
import com.ride.voiture.Voiture;
import com.ride.voiture.VoitureService;

@Controller
public class DemandeClientController {
	@Autowired
	private DemandeClientService ds;	
	@Autowired
	private DemandeService dsadmin;
	@Autowired
	private VoitureService vs;
	@Autowired
	private UserService us;
	
	@GetMapping("/mesdemandes")
	public String viewClientDemandes(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails cuser = (CustomUserDetails) authentication.getPrincipal();

		java.util.Optional<User> user = us.getUserById(cuser.getId());
		model.addAttribute("user", user.get());
		model.addAttribute("demandes", ds.getDemandes(cuser.getId()));

		return "mesdemandes";
	}
	
	@GetMapping("/nvdemande")
	public String afficherDemande(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails cuser = (CustomUserDetails) authentication.getPrincipal();

		java.util.Optional<User> user = us.getUserById(cuser.getId());
		model.addAttribute("user", user.get());
		
		DemandeClient demande = new DemandeClient();
		model.addAttribute("demande", demande);

		List<Voiture> voitures =  vs.getVoitures();
		model.addAttribute("voitures", voitures);
		return "nvdemande";
	}
	
	@GetMapping("/mesinfos")
	public String afficherInfos(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails cuser = (CustomUserDetails) authentication.getPrincipal();

		java.util.Optional<User> user = us.getUserById(cuser.getId());
		model.addAttribute("user", user.get());
		
		model.addAttribute("total", ds.getDemandes(cuser.getId()).size());
		return "mesinfos";
	}
	
	@PostMapping("/add_demande")
	public String ajouterDemande(@ModelAttribute("demande") DemandeClient demande) {

		demande.setEtat("NV");
		//set IdClient
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails cuser = (CustomUserDetails) authentication.getPrincipal();
		demande.setId_client(cuser.getId());
		
		//set Prix total
		float prix = vs.getVoiture(demande.getIdVoiture()).getPrix();
		if (demande.getChaise()!=null) {
			prix+=30;
		}
		if (demande.getWifi()!=null) {
			prix+=10;
		}
		demande.setPrix(prix);
		
//		if (demande.getChaise()!=1) {
//			demande.setChaise(0);
//		}
//		if (demande.getWifi()!=1) {
//			demande.setWifi(0);
//		}
		ds.insertDemande(demande);
		
		//insert in demandeadmin
		Demande dadmin = new Demande();
		dadmin.setId(demande.getId());
		dadmin.setEtat(demande.getEtat());
		dadmin.setChaise(demande.getChaise());
		dadmin.setWifi(demande.getWifi());
		dadmin.setId_client(demande.getId_client());
		dadmin.setPrix(demande.getPrix());
		dsadmin.saveDemande(dadmin);
		
		return "redirect:/mesdemandes";
	}
	
//	public User getUserLoggedIn() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		CustomUserDetails cuser = (CustomUserDetails) authentication.getPrincipal();
//
//		java.util.Optional<User> user = us.getUserById(cuser.getId());
//
//		return user.get();
//	}
	
}
