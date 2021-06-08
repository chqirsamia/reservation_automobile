package com.ride;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ride.voiture.Voiture;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where u.id=?1")
	User  findUserByID(Long id);
	@Query("select u from User u where u.role='A'")
	List<User> findAdmin();
	@Query("select u from User u where u.email=?1")
	Optional<User> findUserByEmail(String email);

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.email=?1")
	User findByEmail(String email);

}
