package com.ride.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ride.model.Demande;
import com.ride.repository.DemandeRepository;

@Service
@Component
public class DemandeServiceImpl implements DemandeService{

	@Autowired
	private DemandeRepository demanderepo;
	
	@Override
	public List<Demande> getDemandes(Long id) {
		
		return demanderepo.findByIdClient(id);
	}

	@Override
	public Long insertDemande(Demande demande) {
		Demande d = demanderepo.save(demande);
		return d.getId();
	}

	@Override
	public Long updateDemande(Demande demande) {
		Demande d = demanderepo.save(demande);
		return d.getId();
	}

	@Override
	public int deleteUpdate(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
