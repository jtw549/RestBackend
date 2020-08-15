package com.commerce.app.COMMERCE_Domain.config;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
 
import com.mongodb.MongoClient;
 
@Configuration
public class SpringMongoConfig1 {
 
	//public @Bean
/*	MongoDbFactory mongoDbFactory() throws Exception {
		UsernamePasswordCredentials userCredentials = new UsernamePasswordCredentials("commerce-main-app", "commerceAppC0nn3ction"); 
		return new MongoDbFactory(new MongoClient("ds11111.mongolab.com",45907), "commerce-sandbox-dev",userCredentials);
	}
 
	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
 
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
 
		return mongoTemplate;
 
	}*/
 
}
