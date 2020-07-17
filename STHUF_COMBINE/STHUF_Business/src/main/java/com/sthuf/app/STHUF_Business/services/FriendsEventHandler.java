package com.sthuf.app.STHUF_Business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class FriendsEventHandler implements FriendsService{
	
	private MongoTemplate mongoTemplate;
}
