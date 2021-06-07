package com.ride.demande;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ride.User;
import com.ride.voiture.Voiture;
@Repository

public interface DemandeRepository extends JpaRepository<Demande, Long>{
	
	@Query("select d from Demande d where d.id=?1")
    Demande  findDemandeByID(Long id);
	@Query("select d from Demande d where d.etat='F'")
	List <Demande> findDemandeT();
	@Query("select d from Demande d where d.etat='NF'")
	List <Demande> findDemandeNT();
	@Query("select u from User u where u.id in (select d.id_client from Demande d where d.id=?1)")
	User findUser(Long id);
}

