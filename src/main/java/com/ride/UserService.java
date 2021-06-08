package com.ride;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.voiture.Voiture;
import com.ride.voiture.VoitureRepository;

@Service
public class UserService {
	private final UserRepository userRepository ;
	@Autowired

	public UserService(UserRepository userRepository) {
		this.userRepository =userRepository;
	}
		public List<User> getAdmins() {
			return userRepository.findAdmin();
		}
		public User  getAdmin(Long id)
		{
			return userRepository.findUserByID(id);
		}
		public void addNewAdmin(User user) {
			Optional <User> userByID=userRepository.findUserByEmail(user.getEmail());
			if (userByID.isPresent())
				throw new IllegalStateException("email existant");
			user.setRole("A");
		userRepository.save(user);
		}
		public void deleteUser(long id) {
			userRepository.deleteById(id);
			
		}
		@Transactional
		public void updateAdmin(String email,String telephone,Long id) {
			Optional <User> userByID=userRepository.findById(id);
			User user=userByID.get();
			user.setEmail(email);
			user.setTel(telephone);
			
		}

}
