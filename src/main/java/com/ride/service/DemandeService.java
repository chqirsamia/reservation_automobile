package com.ride.service;

import java.util.List;
import com.ride.model.Demande;

public interface DemandeService {

	public List<Demande> getDemandes(Long id);
	public Long insertDemande(Demande demande);
	public int deleteUpdate(Long id);
	public Long updateDemande(Demande demande);
}
