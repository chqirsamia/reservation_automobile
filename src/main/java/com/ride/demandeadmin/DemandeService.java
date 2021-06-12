package com.ride.demandeadmin;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.User;
import com.ride.voiture.Voiture;

@Service
public class DemandeService {
	private final DemandeRepository demandeRepository ;
	@Autowired

	public DemandeService(DemandeRepository demandeRepository) {
		this.demandeRepository=demandeRepository;
	}
		public List<Demande> getDemandes() {
			return demandeRepository.findAll();
		}
		public Demande  getDemande(Long id)
		{
			return demandeRepository.findDemandeByID(id);
		}
		public List<Demande> getDemandesT() {
			
			return demandeRepository.findDemandeT();
		}
public List<Demande> getDemandesNT() {
			
			return demandeRepository.findDemandeNT();
		}
public User getusers(Long id) {
	
	return demandeRepository.findUser( id);
}
@Transactional
public void updateDemande(Long id) {
	Optional <Demande> demandeByID=demandeRepository.findById(id);
	Demande demande=demandeByID.get();
	demande.setEtat("F");;
	
}
		
		
public Demande  saveDemande(Demande d)
{
	return demandeRepository.save(d);
}		

}
