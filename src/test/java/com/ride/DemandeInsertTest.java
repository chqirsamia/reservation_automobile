package com.ride;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.ride.model.Demande;
import com.ride.model.User;
import com.ride.repository.DemandeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DemandeInsertTest {
	
	@Autowired
	private DemandeRepository dr;
	@Autowired
	private TestEntityManager entityManager;
	@Test
	public void test() {
		Demande d=null;
		Optional<Demande> opt= dr.findById(1l);
		if(opt.isPresent()) {
			d=opt.get();
			d.setLieu_dep("Boulevard Bordeaux");
			dr.save(d);
			
			Demande getD = entityManager.find(Demande.class, d.getId());
			
			assertThat(getD.getLieu_dep()).isEqualTo(d.getLieu_dep());
		}
		
//		d.setChaise(1);

	}

}
