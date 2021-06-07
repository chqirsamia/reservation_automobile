package com.ride.voiture;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long>{
	
	@Query("select v from Voiture v where v.id=?1")
Voiture  findVoitureByID(Long id);
	@Query("select id from Voiture where matricule=?1")
	Optional <Voiture> findVoitureByMatricule(String Matricule);
}
