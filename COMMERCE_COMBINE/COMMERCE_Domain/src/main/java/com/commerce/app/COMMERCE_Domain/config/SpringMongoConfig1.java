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
		UserCredentials userCredentials = new UserCredentials("sthuf-main-app", "SthufAppC0nn3ction"); 
		return new SimpleMongoDbFactory(new MongoClient("ds045907.mongolab.com",45907), "sthuf-sandbox-dev",userCredentials);
	}
 
	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
 
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
 
		return mongoTemplate;
 
	}
 
}
