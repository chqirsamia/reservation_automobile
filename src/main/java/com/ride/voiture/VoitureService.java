package com.ride.voiture;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;


@Service
public class VoitureService {
private final VoitureRepository voitureRepository ;
@Autowired

public VoitureService(VoitureRepository VoitureRepository) {
	this.voitureRepository=VoitureRepository;
}
	public List<Voiture> getVoitures() {
		return voitureRepository.findAll();
	}
	public Voiture  getVoiture(Long id)
	{
		return voitureRepository.findVoitureByID(id);
	}
	public void addNewVoiture(Voiture voiture) {
		Optional <Voiture> voitureByMatricule=voitureRepository.findVoitureByMatricule(voiture.getMatricule());
		if (voitureByMatricule.isPresent())
			throw new IllegalStateException("matricule existante");
	voitureRepository.save(voiture);
	}
	public void deleteVoiture(long id) {
		voitureRepository.deleteById(id);
		
	}
	@Transactional
	public void updateVoiture(Long id,String pic, int nombre_places, float prix) {
		Optional <Voiture> voitureByID=voitureRepository.findById(id);
		Voiture voiture=voitureByID.get();
		voiture.setPic(pic);
		voiture.setNombre_places(nombre_places);
		voiture.setPrix(prix);
	}

	
}
