package com.lcwd.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.userService.UserServiceImpl;

@RestController
@RequestMapping("/users/")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	//create 
	
	
	@PostMapping("/")
	public ResponseEntity<User>createUser(@RequestBody User user){
		
		User createUser = this.userService.createUser(user);
		
		return new ResponseEntity<User>(createUser, HttpStatus.CREATED);
	}
	
	
	// get user
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User>getUser(@PathVariable("userId") String userId){
		
		User singleUser = this.userService.getSingleUser(userId);
		
		return new ResponseEntity<User>(singleUser,HttpStatus.OK);
	}
	
	//get users
	
	@GetMapping("/allUser")
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = this.userService.getUsers();
		
		return ResponseEntity.ok(users);
	}
	
	//get user
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User>deleteUser(@PathVariable String userId){
		
		this.userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//update user
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User>updateUser(@PathVariable String userId,@RequestBody User user){
		User updateUSer = this.userService.updateUSer(userId, user);
		
		return new ResponseEntity<User>(updateUSer, HttpStatus.OK);
	}

}
