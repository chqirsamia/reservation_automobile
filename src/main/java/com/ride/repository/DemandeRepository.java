package com.ride.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ride.model.Demande;
@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long>{

	List<Demande> findByIdClient(Long idClient);
}
