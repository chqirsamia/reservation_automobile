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

import com.ride.demandeclient.DemandeClient;
import com.ride.demandeclient.DemandeClientRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DemandeInsertTest {
	
	@Autowired
	private DemandeClientRepository dr;
	@Autowired
	private TestEntityManager entityManager;
	@Test
	public void test() {
		DemandeClient d=null;
		Optional<DemandeClient> opt= dr.findById(1l);
		if(opt.isPresent()) {
			d=opt.get();
			d.setLieu_dep("Boulevard Bordeaux");
			dr.save(d);
			
			DemandeClient getD = entityManager.find(DemandeClient.class, d.getId());
			
			assertThat(getD.getLieu_dep()).isEqualTo(d.getLieu_dep());
		}
		

	}

}
