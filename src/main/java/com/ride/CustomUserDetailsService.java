package com.ride;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}
	public List<User> getAdmins() {
		return repo.findAdmin();
	}
	public User  getAdmin(Long id)
	{
		return repo.findUserByID(id);
	}
	public void addNewAdmin(User user) {
		User userByID=repo.findByEmail(user.getEmail());
		if (userByID!= null)
			throw new IllegalStateException("email existant");
		user.setRole("A");
	repo.save(user);
	}
	public void deleteUser(long id) {
		repo.deleteById(id);
		
	}
	@Transactional
	public void updateAdmin(String email,String telephone,Long id) {
		Optional <User> userByID=repo.findById(id);
		User user=userByID.get();
		user.setEmail(email);
		user.setTel(telephone);
		
	}
}
