package com.grocery.shopping.service;

import java.util.List;

import com.grocery.shopping.entity.User;

public interface UserService {

	User getUser(int userId);

	User create(User user);

	List<User> getAllUser();

	void updateUser(User user);

	void deleteUser(int userId);

}
