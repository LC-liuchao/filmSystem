package com.film.mapper;

import com.film.entity.User;

public interface UserMapper {
	
	//保存用户
	public void save(User user);
	
	//根据用户名查找用户
	public User queryUserByName(String username);
}
