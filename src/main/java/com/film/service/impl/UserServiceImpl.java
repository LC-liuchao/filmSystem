package com.film.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.film.entity.User;
import com.film.mapper.UserMapper;
import com.film.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void saveUser(User user) {
		userMapper.save(user);
	}

	@Override
	public String queryUser(String username, String password) {
		User user = userMapper.queryUserByName(username);
		if(user != null){
			if(password.equals(user.getPassword())){
				return "101";//登录成功
			}else {
				return "102";//密码错误
			}
		}else {
			return "102";//用户不存在
		}
	}
}
