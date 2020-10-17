package com.commerce.app.COMMERCE_Business.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.Tags.TagEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyEvent;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.InventoryTags;
import com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty;
import com.commerce.app.COMMERCE_Domain.repository.TagsRepository;

@Service("tagService")
@ComponentScan("com.commerce.app.COMMERCE_Domain.repository")
public class TagEventHandler implements TagService{

	private static Logger LOG = LoggerFactory.getLogger(TagEventHandler.class);
	
	@Autowired
	private TagsRepository tagsRepository;
	
	public TagEvent addTag(TagEvent addTagEvent) {
		InventoryTags inventoryTag = addTagEvent.getTagDetails().fromTagDetails();
		inventoryTag = tagsRepository.addTag(inventoryTag);
		return new TagEvent(inventoryTag);
	}
	
	public boolean deleteTag(TagEvent deleteTagEvent) {
		InventoryTags inventoryTag = deleteTagEvent.getTagDetails().fromTagDetails();
		boolean deletedTag = tagsRepository.deleteTag(inventoryTag);
		return deletedTag;
	}
	
	//added for later use
	public TagEvent updateTag(TagEvent updateTagEvent) {
		InventoryTags inventoryTag = updateTagEvent.getTagDetails().fromTagDetails();
		inventoryTag = tagsRepository.updateTag(inventoryTag);
		return new TagEvent(inventoryTag);
	}

	public TagEvent getTags(TagEvent getTagEvent) {
		InventoryTags inventoryTag = getTagEvent.getTagDetails().fromTagDetails();
		ArrayList<InventoryTags> tags = tagsRepository.getTags(inventoryTag);
		return new TagEvent(tags);
	}
}
