package com.commerce.app.COMMERCE_Business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class EcommerceEventHandler implements EcommerceService{
	
	private MongoTemplate mongoTemplate;
}
