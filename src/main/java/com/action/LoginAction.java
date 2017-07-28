package com.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
import com.service.user.IUserService;

@Controller
public class LoginAction {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/login")
	public String login(User user){
		user = userService.getUser(user);
		if(user!=null){
			return "success";
		}else{
			return "fail";
		}
	}
}
