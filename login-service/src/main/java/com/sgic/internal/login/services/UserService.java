package com.sgic.internal.login.services;

import com.sgic.internal.login.entities.User;

public interface UserService {
	public User getByEmail(String email);	
}
