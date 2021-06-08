package com.ride.voiture;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ride.User;
@Controller
@RequestMapping(path="/voitures")
public class VoitureController {

	private final VoitureService  VoitureService ;
	public VoitureController(VoitureService VoitureService) {
		this.VoitureService=VoitureService;
	}
	@GetMapping
	public  String  getVoitures(Model model) {
		model.addAttribute("list", VoitureService.getVoitures());
		return "voiture";
	}
	@GetMapping(path="offres")
	public  String  getOffres(Model model) {
		model.addAttribute("list", VoitureService.getVoitures());
		return "voiture-client";
	}
	@PostMapping(path="insertNewVoiture")
	public String insertNewVoiture(@Valid Voiture voiture, BindingResult result,Model model)
	{VoitureService.addNewVoiture(voiture);
	return "redirect:/voitures";}
	
	
	@GetMapping(path="delete/{VoitureID}")
	public String deleteVoiture(@PathVariable("VoitureID") Long id) {
		VoitureService.deleteVoiture(id);
		return "redirect:/voitures";}
	
	
	@GetMapping (path="edit/{VoitureID}")
	public String editVoiture(@PathVariable Long VoitureID,Model model) {
		Voiture voiture=VoitureService.getVoiture(VoitureID);
		
		model.addAttribute("voiture",voiture);
		return "voiture-form";
	}
	
	
	@PostMapping (path="update/{VoitureID}")
	public String updateVoiture (@PathVariable Long VoitureID,@RequestParam(required=false) String pic,
			@RequestParam(required=false) int nombre_places,@RequestParam(required=false)float prix) {
		VoitureService.updateVoiture(VoitureID,pic,nombre_places,prix);
		return "redirect:/voitures";}
	}

