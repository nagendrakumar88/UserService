package com.lcwd.user.service.userService;

import java.util.List;

import com.lcwd.user.service.entity.User;

public interface UserService {
	
	//create
	
	public User createUser(User user);
	
	//get all user
	
	public List<User>getUsers();
	
	//get single user
	
	public User getSingleUser(String userId);
	
	// delete user
	
	public void deleteUser(String userId);
	
	//update user
	
	public User updateUSer(String userId, User user);

}
