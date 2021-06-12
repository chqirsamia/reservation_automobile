package com.ride.demandeadmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ride.voiture.Voiture;
import com.ride.User;
import com.ride.demandeadmin.Demande;


@Controller
@RequestMapping(path="/demandes")
public class DemandeController {
	private final DemandeService  DemandeService ;
	public DemandeController(DemandeService DemandeService) {
		this.DemandeService=DemandeService;
	}
	@GetMapping
	public  String  getDemandes(Model model) {
		//infoClient();
		model.addAttribute("list", DemandeService.getDemandes());
		
		return "list-demande";
	}
	
	@GetMapping("/ShowDemandeT")
	public String showDemande(Model model) {
		model.addAttribute("list",DemandeService.getDemandesT());
		
		return "list-demande";
	}
	
	@GetMapping (path="/EditDemande/{id}")
	public String editDemande(@PathVariable Long id,Model model) {
		Demande demande=DemandeService.getDemande(id);
		
		model.addAttribute("demande",demande);
		return "confirm";
	}
	
	
	@PostMapping (path="/UpdateDemande/{id}")
	public String updateVoiture (@PathVariable Long id) {
		DemandeService.updateDemande(id);
		return "redirect:/demandes";}
	
	
	@GetMapping("/ShowDemandeNT")
	public String showDemandeNT(Model model) {
		model.addAttribute("list",DemandeService.getDemandesNT());
		return "list-demande";
	}
}
