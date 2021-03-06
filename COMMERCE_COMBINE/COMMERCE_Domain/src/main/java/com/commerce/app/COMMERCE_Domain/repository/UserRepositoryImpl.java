package com.commerce.app.COMMERCE_Domain.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.commerce.app.COMMERCE_Domain.config.SpringMongoConfig1;
import com.commerce.app.COMMERCE_Domain.domain.Categories;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.LoginEverythingDomain;
import com.commerce.app.COMMERCE_Domain.domain.UserCategories;
import com.commerce.app.COMMERCE_Domain.domain.Users;
import com.commerce.app.COMMERCE_Domain.domain.Users2;
import com.mongodb.client.result.DeleteResult;

@Repository
public class UserRepositoryImpl implements UserRepository{

	ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	Query userQuery;
	
	@Autowired
	SequenceRepository sequenceRepository;
	
	public Users registerUser(Users users) {
		Users userCheck = new Users();
		userQuery = new Query(Criteria.where("email").is(users.getEmail()));
		userCheck = mongoOperation.findOne(userQuery, Users.class);
		if(userCheck !=null){
			//need to set a boolean if the user already exists
		}
		
		users.setUserId((int) sequenceRepository.getNextSequenceId("userID_Sequence"));
		return mongoOperation.save(users);
	}
	
	public LoginEverythingDomain loginUser (Users users,LoginEverythingDomain loginEverythingDomain) {
		
		userQuery = new Query(Criteria.where("email").is(users.getEmail())
				.andOperator(Criteria.where("password").is(users.getPassword())));
		users = mongoOperation.findOne(userQuery, Users.class);
		if(users != null) {
			ArrayList<Categories> categories =(ArrayList<Categories>) mongoOperation.findAll(Categories.class);
			Query userCategoryQuery = new Query(Criteria.where("userId").is(users.getUserId()));
			ArrayList<UserCategories> userCategories = (ArrayList<UserCategories>) mongoOperation.find(userCategoryQuery, UserCategories.class);
			//Query userFriendsQuery = new Query(Criteria.where("userId").is(users.getUserId()));
			//ArrayList<Friends> userFriends = (ArrayList<Friends>) mongoOperation.find(userFriendsQuery, Friends.class);
			Query userInventoryQuery = new Query(Criteria.where("userId").is(users.getUserId()));
			ArrayList<Inventories> userInventories = (ArrayList<Inventories>) mongoOperation.find(userInventoryQuery, Inventories.class);
			//Query userMessagesQuery = new Query(Criteria.where("userId").is(users.getUserId()));
			//ArrayList<Messages> userMessages = (ArrayList<Messages>) mongoOperation.find(userMessagesQuery, Messages.class);
			
			loginEverythingDomain.setCategories(categories);
			Users2 users2 = new Users2();
			users2.setEmail(users.getEmail());
			users2.setFirstName(users.getFirstName());
			users2.setLastName(users.getLastName());
			users2.setProfilePicUrl(users.getProfilePicUrl());
			users2.setUserBio(users.getUserBio());
			users2.setUserId(users.getUserId());
			users2.setUserName(users.getUserName());
			//users2.setUsersFriends();
			users2.setUsersInventories(userInventories);
			//users2.setUsersMessages(usersMessages);
			users2.setUserSocialAccounts(users.isUserSocialAccounts());
			users2.setUsersCategories(userCategories);
			users2.setUserPrivacy(users.getUserPrivacy());
			loginEverythingDomain.setUsers(users2);
			//loginEverythingDomain.setUsersCategories(userCategories);
			//loginEverythingDomain.setUsersFriends(userFriends);
			//loginEverythingDomain.setUsersInventories(userInventories);
			//loginEverythingDomain.setUsersMessages(userMessages);
		}
		
		return loginEverythingDomain;
	}
	
	public Users updateUser(Users users) {
		return mongoOperation.save(users);
		
	}
	
	public boolean deleteUser(Users users) {
		DeleteResult DR= mongoOperation.remove(users);
		return DR.wasAcknowledged();
		
	}

	public Users getAccountInfo(Users users) {
		userQuery = new Query(Criteria.where("userId").is(users.getUserId()));
		users = mongoOperation.findOne(userQuery, Users.class);
		return users;
	
	}

	public boolean logoutUser(Users users) {
		boolean updated =false;
		return updated;
	}


}
