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
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.InventoryTags;

@Repository
public class ItemsRepositoryImpl implements ItemsRepository{

	ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	Query searchInventoryQuery;
	
	@Autowired
	SequenceRepository sequenceRepository;
	
	public Inventories addItem (Inventories inventories) {
		inventories.setInventoryId((int) sequenceRepository.getNextSequenceId("itemID_Sequence"));
		mongoOperation.save(inventories);
		searchInventoryQuery = new Query(Criteria.where("name").is(inventories.getName())
				.andOperator(Criteria.where("userId").is(inventories.getUserId())));
		inventories = mongoOperation.findOne(searchInventoryQuery, Inventories.class);
		
		return inventories;
	}
	
	public boolean deleteItem(Inventories inventories) {
		boolean deleted = false;
		searchInventoryQuery = new Query(Criteria.where("inventoryId").is(inventories.getInventoryId())
				.andOperator(Criteria.where("userId").is(inventories.getUserId())));
		mongoOperation.remove(searchInventoryQuery,Inventories.class);
		deleted = true;
		
		return deleted;
	}
	
	
	public Inventories updateItem(Inventories inventories) {
		
		mongoOperation.save(inventories);
		searchInventoryQuery = new Query(Criteria.where("inventoryId").is(inventories.getInventoryId())
				.andOperator(Criteria.where("userId").is(inventories.getUserId())));
		inventories = mongoOperation.findOne(searchInventoryQuery, Inventories.class);
		
		return inventories;
		
	}
	
	public Inventories getItem(Inventories inventories) {
		searchInventoryQuery = new Query(Criteria.where("userId").is(inventories.getUserId())
				.andOperator(Criteria.where("inventoryId").is(inventories.getInventoryId())));
		inventories = mongoOperation.findOne(searchInventoryQuery, Inventories.class);
		return null;
	}
	public ArrayList<Inventories> getItems(Inventories inventories){
		searchInventoryQuery = new Query(Criteria.where("userId").is(inventories.getUserId()));
		ArrayList<Inventories> inventoriesArrayList= (ArrayList<Inventories>) mongoOperation.find(searchInventoryQuery, Inventories.class);
		
		return null;
	}
	public ArrayList<Inventories> getItemsbyCategory(Inventories inventories){
		searchInventoryQuery = new Query(Criteria.where("userId").is(inventories.getUserId())
				.andOperator(Criteria.where("userCategoryId").is(inventories.getUserCategoryId())));
		ArrayList<Inventories> inventoriesArrayList= (ArrayList<Inventories>) mongoOperation.find(searchInventoryQuery, Inventories.class);
		
		return null;
	}
	public Inventories bookmarkItem(Inventories inventories) {
		searchInventoryQuery = new Query(Criteria.where("userId").is(inventories.getUserId())
				.andOperator(Criteria.where("inventoryId").is(inventories.getInventoryId())));
		inventories = mongoOperation.findOne(searchInventoryQuery, Inventories.class);
		
		return null;
	}
}
