package com.commerce.app.COMMERCE_Domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
 
import com.mongodb.MongoClient;
 
@Configuration
public class SpringMongoConfig1 {
 
	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		UserCredentials userCredentials = new UserCredentials("commerce-main-app", "commerceAppC0nn3ction"); 
		return new SimpleMongoDbFactory(new MongoClient("ds11111.mongolab.com",45907), "commerce-sandbox-dev",userCredentials);
	}
 
	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
 
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
 
		return mongoTemplate;
 
	}
 
}
