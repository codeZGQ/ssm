package com.service.user;

import java.util.List;

import com.entity.User;

public interface IUserService {

	User getUser(User user);

	List<User> listUser();

}
