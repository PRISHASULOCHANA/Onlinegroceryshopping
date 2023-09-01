package com.grocery.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.shopping.entity.User;
import com.grocery.shopping.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService{
     
	@Autowired

	private UserRepository userrepository;

	@Override
	public User getUser(int userId) {
		Optional<User> optional=userrepository.findById(userId);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
@Override

	public User create(User user) {
	    return userrepository.save(user);
		 
		}
@Override
	public List<User> getAllUser(){
		return userrepository.findAll();
	}

@Override
	public void updateUser(User user) {
		userrepository.save(user);
		
	}

@Override
	public void deleteUser(int userId) {
		Optional<User> optional = userrepository.findById(userId);
		if(!optional.isEmpty()) {
			userrepository.delete(optional.get());
		}
	}
}