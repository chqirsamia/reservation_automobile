package com.ride;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	private UserRepository repo;
	@Autowired
	private TestEntityManager entityManager;
	@Test
	public Long testCreateUser() {
		User user=new User();
		user.setNom("Saidi");
		user.setPrenom("Said");
		user.setEmail("said@saidii.com");
		user.setSexe("H");
		user.setTel("0675467328");
		user.setPassword("said");
		user.setRole("C");
		
		User savedUser = repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
		return savedUser.getId();
	}
	

	@Test
	public User  testFindUserByEmail() {
		String email="said@saidii.com";
		User user=repo.findByEmail(email);
		assertThat(user).isNotNull();
		return user;
	}


}




















