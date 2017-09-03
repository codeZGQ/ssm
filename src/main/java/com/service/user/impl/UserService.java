package com.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.user.IUserDao;
import com.entity.User;
import com.service.user.IUserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService{

	@Autowired
	@Resource
	private IUserDao userDao;
	
	@Transactional
	public User getUser(User user) {
		String pwd = user.getPwd();
		user = userDao.getUser(user);
		if(user!=null){
			if(user.getPwd().equals(pwd)){
				return user;
			}
		}
		return null;
	}

	public List<User> listUser() {
		List<User> list = userDao.listUser();
		return list;
	}

	
}
