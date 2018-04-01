package com.film.service;

import com.film.entity.User;

public interface UserService {

	public void saveUser(User user);
	
	public String queryUser(String username,String password);
}
