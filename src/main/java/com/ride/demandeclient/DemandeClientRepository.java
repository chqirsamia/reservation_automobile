package com.ride.demandeclient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeClientRepository extends JpaRepository<DemandeClient, Long>{

	List<DemandeClient> findByIdClient(Long idClient);
}
