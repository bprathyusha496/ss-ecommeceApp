package com.rgt.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgt.app.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findUserByEmail(String email);

	User findById(String name);
	User findByemail(String email);

}
