package com.sgic.internal.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.login.entities.ConfirmationToken;



public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
	
}
