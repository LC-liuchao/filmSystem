package com.film.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.film.service.UserService;

/**
 * 
 * @author 柳超
 * @date 2018年3月13日 下午2:18:52
 */
@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String preLogin(HttpSession session) throws Exception {
		session.setAttribute("username", null);
		//跳转jsp页面
		return "login";
	}
	
	@RequestMapping("/loginHandler")
	@ResponseBody
	public String login(HttpSession session,String username,String password) throws Exception {
		String hint = userService.queryUser(username, password);
		if(hint == "101"){
			session.setAttribute("username", username);
		}
		return hint;
	}
}
