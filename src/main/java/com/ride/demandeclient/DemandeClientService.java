package com.ride.demandeclient;

import java.util.List;

public interface DemandeClientService {

	public List<DemandeClient> getDemandes(Long id);
	public Long insertDemande(DemandeClient demande);
	public int deleteUpdate(Long id);
	public Long updateDemande(DemandeClient demande);
}
