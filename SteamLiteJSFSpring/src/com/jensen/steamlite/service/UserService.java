package com.jensen.steamlite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jensen.steamlite.model.entity.User;
import com.jensen.steamlite.model.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User getUserOne() {
		return userRepository.findOne(4);
	}
	@Transactional
	public User getUserByUserName(String userName) {
		return userRepository.findUserByUserName(userName);
	}
	@Transactional
	public void createUser(User user) {
		userRepository.save(user);
	}
	@Transactional
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	@Transactional
	public void updateUser(String userName, String email, String newPassword, User user) {
		User peristentUser = userRepository.findOne(user.getUserId());
		
		peristentUser.setUserName(userName);
		peristentUser.setUserEmail(email);
		peristentUser.setUserPassword(newPassword);
		
		userRepository.save(peristentUser);
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	

	
}
