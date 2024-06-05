package com.ashu.user.service.services;

import java.util.List;

import com.ashu.user.service.entities.User;

public interface UserService {
	
	//User operations
	
	//create
	User saveUser(User user);
	
	//get All users
	List<User> getAllUser();
	
	
	//get single user
	User getUser(String userId);
	
	//delete user
	void deleteUserById(String userId);
	
	//update user
	User updateUser(User user);

}
