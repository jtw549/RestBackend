package com.commerce.app.COMMERCE_Domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
 
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
 
@Configuration
public class SpringMongoConfig extends AbstractMongoClientConfiguration {
 
	//make this a property file.
	public String getDatabaseName() {
		return "commerce-sandbox-dev";
	}
 
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("ds11111.mongolab.com",45907);
	}
}
