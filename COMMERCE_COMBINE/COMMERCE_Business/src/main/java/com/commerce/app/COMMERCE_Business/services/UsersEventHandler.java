package com.commerce.app.COMMERCE_Business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.Users.*;
import com.commerce.app.COMMERCE_Domain.domain.LoginEverythingDomain;
import com.commerce.app.COMMERCE_Domain.domain.Users;
import com.commerce.app.COMMERCE_Domain.repository.UserRepository;

@Service("userService")
@ComponentScan("com.commerce.app.COMMERCE_Domain.repository")
public class UsersEventHandler implements UsersService{

	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	Query userQuery;
	
	@Override
	public UserEvent registerUser(UserEvent registerUserEvent) {
		Users users = registerUserEvent.getUserDetails().fromUserDetails();
		users = userRepository.registerUser(users);
		return new UserEvent(users);
	}
	
	@Override
	public UserEvent updateUser(UserEvent updateUserEvent) {
		Users users = updateUserEvent.getUserDetails().fromUserDetails();
		users= userRepository.updateUser(users);
		return new UserEvent(users);
	}
	
	@Override
	public boolean deleteUser(UserEvent deleteUserEvent) {
		Users users = deleteUserEvent.getUserDetails().fromUserDetails();
		boolean deleted = userRepository.deleteUser(users);
		return deleted;
	}
	
	@Override
	public UserEvent getAccountInfo(UserEvent getUserAccountInfoEvent) {
		Users users = getUserAccountInfoEvent.getUserDetails().fromUserDetails();
		users=userRepository.getAccountInfo(users);
		return new UserEvent(users);
	}
	
	@Override
	public UserEvent loginUser(UserEvent loginUserEvent) {
		Users users = loginUserEvent.getUserDetails().fromUserDetails();
		LoginEverythingDomain loginEverythingDomain=new LoginEverythingDomain();
		loginEverythingDomain = userRepository.loginUser(users,loginEverythingDomain);
		return new UserEvent(loginEverythingDomain);
	}
	
	@Override
	public boolean logoutUser(UserEvent loginUserEvent) {
		//Need to figure out what this is going to do
		Users users = loginUserEvent.getUserDetails().fromUserDetails();
		boolean loggedout = userRepository.logoutUser(users);
		return loggedout;
	}
	
}
