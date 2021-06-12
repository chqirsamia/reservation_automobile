package com.ride.voiture;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.ride.User;
import com.ride.UserRepository;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class VoitureRepositoryTests {

		@Autowired
		private VoitureRepository repo;
		@Autowired
		private TestEntityManager entityManager;
		@Test
		public void testCreateVoiture() {
			Voiture voiture=new Voiture();
			voiture.setMatricule("P5642");
			voiture.setNombre_places(4);
			voiture.setGenre("Limousine");
			voiture.setMarque("Mercedes");
			voiture.setPic("https://media.istockphoto.com/photos/red-bus-picture-id171297525?s=612x612");
			voiture.setPrix(1500);
			Voiture savedVoiture = repo.save(voiture);
			
			Voiture existVoiture = entityManager.find(Voiture.class, savedVoiture.getId());
			
			assertThat(existVoiture.getMatricule()).isEqualTo(voiture.getMatricule());
		}
		

		


}
