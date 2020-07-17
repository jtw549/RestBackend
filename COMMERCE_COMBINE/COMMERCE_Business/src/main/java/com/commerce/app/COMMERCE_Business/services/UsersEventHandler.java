package com.commerce.app.COMMERCE_Business.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.Users.*;
import com.commerce.app.COMMERCE_Domain.domain.Categories;
import com.commerce.app.COMMERCE_Domain.domain.Friends;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.LoginEverythingDomain;
import com.commerce.app.COMMERCE_Domain.domain.Messages;
import com.commerce.app.COMMERCE_Domain.domain.UserCategories;
import com.commerce.app.COMMERCE_Domain.domain.Users;
import com.commerce.app.COMMERCE_Domain.repository.UserRepository;

@Service("userService")
@ComponentScan("com.sthuf.app.STHUF_Domain.repository")
public class UsersEventHandler implements UsersService{

	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	Query userQuery;
	
	@Override
	public UserRegisteredEvent registerUser(RegisterUserEvent registerUserEvent) {
		Users users = registerUserEvent.getUserDetails().fromUserDetails();
		users = userRepository.registerUser(users);
		
		return new UserRegisteredEvent(users);
	}
	
	@Override
	public UserUpdatedEvent updateUser(UpdateUserEvent updateUserEvent) {
		Users users = updateUserEvent.getUserDetails().fromUserDetails();
		mongoTemplate.save(users);
		return new UserUpdatedEvent(users);
	}
	
	@Override
	public UserDeletedEvent deleteUser(DeleteUserEvent deleteUserEvent) {
		Users users = deleteUserEvent.getUserDetails().fromUserDetails();
		mongoTemplate.remove(users);
		return new UserDeletedEvent(users);
	}
	
	@Override
	public UserAccountInfoGottenEvent getAccountInfo(GetUserAccountInfoEvent getUserAccountInfoEvent) {
		Users users = getUserAccountInfoEvent.getUserDetails().fromUserDetails();
		userQuery = new Query(Criteria.where("userId").is(users.getUserId()));
		users = mongoTemplate.findOne(userQuery, Users.class);
		return new UserAccountInfoGottenEvent(users);
	}
	
	@Override
	public UserLoggedInEvent loginUser(LoginUserEvent loginUserEvent) {
		Users users = loginUserEvent.getUserDetails().fromUserDetails();
		LoginEverythingDomain loginEverythingDomain=new LoginEverythingDomain();
		loginEverythingDomain = userRepository.loginUser(users,loginEverythingDomain);
		return new UserLoggedInEvent(loginEverythingDomain);
	}
	
	@Override
	public UserLoggedOutEvent logoutUser(LoginUserEvent loginUserEvent) {
		//Need to figure out what this is going to do
		Users users = loginUserEvent.getUserDetails().fromUserDetails();
		return new UserLoggedOutEvent(users);
	}
	
}
