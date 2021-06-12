package com.ride;

import java.util.List;
import java.util.Optional;


public interface UserService {

	public List<User> getUsers();
	public Long insertUser(User user);
	public Long updateUser(int id);
	public Long deleteUser(int id);
	public Optional<User> getUserById(Long id);
}
