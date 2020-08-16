package com.commerce.app.COMMERCE_Business.services;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class FriendsEventHandler implements FriendsService{
	
	private MongoTemplate mongoTemplate;
}
