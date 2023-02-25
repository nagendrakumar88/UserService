package com.lcwd.user.service.userService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userrepository;

	@Override
	public User createUser(User user) {
		
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		return this.userrepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return this.userrepository.findAll();
	}

	@Override
	public User getSingleUser(String userId) {
		return this.userrepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User With given id is not fount on server"+userId));
	}

	@Override
	public void deleteUser(String userId) {
		
		User user = this.userrepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not Present indatabase.."));
		this.userrepository.delete(user);
		
	}

	@Override
	public User updateUSer(String userId, User user) {
		User user2 = this.userrepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("This user not Present in database..."));
		
		user2.setAddress(user.getAddress());
		user2.setFirstName(user.getFirstName());
		user2.setLastName(user.getLastName());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		
		
		return this.userrepository.save(user2);
	}

}
