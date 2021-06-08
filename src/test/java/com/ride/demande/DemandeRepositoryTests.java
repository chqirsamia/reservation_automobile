package com.ride.demande;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.ride.UserRepositoryTests;
import com.ride.voiture.Voiture;
import com.ride.voiture.VoitureRepository;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DemandeRepositoryTests {


			@Autowired
			private DemandeRepository repo;
			@Autowired
			private UserRepositoryTests repoTest;
			@Autowired
			private TestEntityManager entityManager;
			@Test
			public Long testCreateDemande() {
				Demande demande=new Demande();
				demande.setChaise(0);
				demande.setEtat("NF");
				demande.setId_client(repoTest.testFindUserByEmail().getId());
				demande.setEmail(repoTest.testFindUserByEmail().getEmail());
				demande.setNom(repoTest.testFindUserByEmail().getNom());
				demande.setPrenom(repoTest.testFindUserByEmail().getPrenom());
				demande.setPrix(200);
				demande.setTel(repoTest.testFindUserByEmail().getTel());
				demande.setWifi(0);
				Demande savedDemande = repo.save(demande);
				
				Demande existDemande = entityManager.find(Demande.class, savedDemande.getId());
				
				assertThat(existDemande.getNom()).isEqualTo(demande.getNom());
				return demande.getId();
			}
			

			
}
