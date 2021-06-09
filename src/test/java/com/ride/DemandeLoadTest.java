package com.ride;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.ride.model.Demande;
import com.ride.repository.DemandeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DemandeLoadTest {
	@Autowired
	private DemandeRepository dr;

	
	@Test
	void test() throws Exception {
		
		List<Demande> demandes = dr.findByIdClient(1l);
		int size = demandes.size();

		List<Long> ids = new ArrayList<>();
		for (int i = 0; i<size; i++) {
			ids.add(demandes.get(i).getId());
		}

		int sizeA = dr.findAllById(ids).size();
		assertThat(size).isEqualTo(sizeA);
	}	
}
	
