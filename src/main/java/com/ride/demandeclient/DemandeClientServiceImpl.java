package com.ride.demandeclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class DemandeClientServiceImpl implements DemandeClientService{

	@Autowired
	private DemandeClientRepository demanderepo;
	
	@Override
	public List<DemandeClient> getDemandes(Long id) {
		
		return demanderepo.findByIdClient(id);
	}

	@Override
	public Long insertDemande(DemandeClient demande) {
		DemandeClient d = demanderepo.save(demande);
		return d.getId();
	}

	@Override
	public Long updateDemande(DemandeClient demande) {
		DemandeClient d = demanderepo.save(demande);
		return d.getId();
	}

	@Override
	public int deleteUpdate(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
