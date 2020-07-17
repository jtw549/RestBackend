package com.commerce.app.COMMERCE_Business.services;

import java.util.ArrayList;

import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.commerce.app.COMMERCE_Business.events.Tags.AddTagEvent;
import com.commerce.app.COMMERCE_Business.events.Tags.DeleteTagEvent;
import com.commerce.app.COMMERCE_Business.events.Tags.TagAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Tags.TagDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Tags.TagUpdatedEvent;
import com.commerce.app.COMMERCE_Business.events.Tags.UpdateTagEvent;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.InventoryTags;

public class TagEventHandler implements TagService{

	
	private MongoTemplate mongoTemplate;
	
	Query inventoryTagsQuery;
	
	public TagAddedEvent addTag(AddTagEvent addTagEvent) {
		InventoryTags inventoryTags = addTagEvent.getTagDetails().fromTagDetails();
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
		
		return new TagAddedEvent(inventories.getInventoryTags());
	}
	
	public TagDeletedEvent deleteTag(DeleteTagEvent deleteTagEvent) {
		InventoryTags inventoryTags = deleteTagEvent.getTagDetails().fromTagDetails();
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
		
		return new TagDeletedEvent(inventories.getInventoryTags());
	}
	
	//added for later use
	public TagUpdatedEvent updateTag(UpdateTagEvent updateTagEvent) {
		InventoryTags inventoryTags = updateTagEvent.getTagDetails().fromTagDetails();
		return new TagUpdatedEvent(inventoryTags);
	}

	/*public TagGottenEvent getTag() {
		
	}*/
}
