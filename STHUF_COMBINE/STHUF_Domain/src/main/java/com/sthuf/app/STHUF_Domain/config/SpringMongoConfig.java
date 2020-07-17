package com.sthuf.app.STHUF_Domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
 
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
 
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {
 
	@Override
	public String getDatabaseName() {
		return "sthuf-sandbox-dev";
	}
 
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("ds045907.mongolab.com",45907);
	}
}
