package com.dao.user;

import java.util.List;

import com.entity.User;

public interface IUserDao {

	User getUser(User user);

	List<User> listUser();

}
