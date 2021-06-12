package com.ride;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userrepository;
	
	@Override
	public List<User> getUsers() {
		return userrepository.findAll();
	}

	@Override
	public Long insertUser(User user) {
		User u = userrepository.save(user);
		return u.getId();
	}

	@Override
	public Long updateUser(int id) {
		// TODO Auto-generated method stub
		return 0l;
	}

	@Override
	public Long deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0l;
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userrepository.findById(id);
	}

	
}
