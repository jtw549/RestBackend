package com.commerce.app.COMMERCE_Domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
 
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
 
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {
 
	//make this a property file.
	@Override
	public String getDatabaseName() {
		return "commerce-sandbox-dev";
	}
 
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("ds11111.mongolab.com",45907);
	}
}
