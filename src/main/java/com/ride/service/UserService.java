package com.ride.service;

import java.util.List;
import java.util.Optional;

import com.ride.model.User;

public interface UserService {

	public List<User> getUsers();
	public Long insertUser(User user);
	public Long updateUser(int id);
	public Long deleteUser(int id);
	public Optional<User> getUserById(Long id);
}
