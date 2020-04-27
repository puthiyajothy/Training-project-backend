package com.sgic.internal.login.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sgic.internal.login.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
 // Find Employee By Email
 	User findUserByEmail(String email);
 	
 	User findUserById(Long id);
 	
 	Optional<User> findByUsernameOrEmail(String username, String email);

}