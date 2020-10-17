package com.commerce.app.COMMERCE_Domain.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.InventoryTags;

public class TagsRepositoryImpl {
	
	private MongoTemplate mongoTemplate;
	
	Query inventoryTagsQuery;
	
	public InventoryTags addTag(InventoryTags inventoryTags){
		//fix this code
		inventoryTagsQuery = new Query(Criteria.where("inventoryId").is(inventoryTags.getInventoryId())
				.andOperator(Criteria.where("userId").is(inventoryTags.getUserId())));
		Inventories inventories = mongoTemplate.findOne(inventoryTagsQuery, Inventories.class);
		ArrayList<InventoryTags> inventTags =inventories.getInventoryTags();
		inventTags.add(inventoryTags);
		inventories.setInventoryTags(inventTags);
		mongoTemplate.save(inventories);
		
		inventoryTagsQuery = new Query(Criteria.where("tagName").is(inventoryTags.getTagName()));
		InventoryTags inventoryTagsSearch =mongoTemplate.findOne(inventoryTagsQuery, InventoryTags.class);
		if(inventoryTagsSearch != null) {
			ArrayList<Integer> iArrayList = inventoryTagsSearch.getInventoryIdArrayList();
			iArrayList.add(inventoryTags.getInventoryId());
			inventoryTagsSearch.setInventoryIdArrayList(iArrayList);
			mongoTemplate.save(inventoryTagsSearch);
		}else {
			inventoryTags.setUserId(666);
			inventoryTags.setInventoryId(666);
			mongoTemplate.save(inventoryTags);
			
		}
		return null;
	}
	public boolean deleteTag(InventoryTags inventoryTags){
		//fix this code
		inventoryTagsQuery = new Query(Criteria.where("inventoryId").is(inventoryTags.getInventoryId())
				.andOperator(Criteria.where("userId").is(inventoryTags.getUserId())));
		Inventories inventories = mongoTemplate.findOne(inventoryTagsQuery, Inventories.class);
		ArrayList<InventoryTags> inventTags =inventories.getInventoryTags();
		inventTags.remove(inventoryTags);
		inventories.setInventoryTags(inventTags);
		mongoTemplate.save(inventories);
		
		inventoryTagsQuery = new Query(Criteria.where("tagName").is(inventoryTags.getTagName()));
		InventoryTags inventoryTagsSearch =mongoTemplate.findOne(inventoryTagsQuery, InventoryTags.class);
		
			ArrayList<Integer> iArrayList = inventoryTagsSearch.getInventoryIdArrayList();
			for(Integer integer :iArrayList) {
				if(integer ==inventoryTags.getInventoryId()) {
					iArrayList.remove(inventoryTags.getInventoryId());
					if(0== iArrayList.size()) {
						mongoTemplate.remove(inventoryTagsSearch);
					}
					break;
				}
			}
			if(iArrayList.size()!=0) {
			inventoryTagsSearch.setInventoryIdArrayList(iArrayList);
			mongoTemplate.save(inventoryTagsSearch);
			}
			
			return false;
	}
	public InventoryTags updateTag(InventoryTags inventoryTags){
		return null;
	}
	public ArrayList<InventoryTags> getTags(InventoryTags inventoryTags){
		return null;
	}
}
