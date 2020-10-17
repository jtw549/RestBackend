package com.commerce.app.COMMERCE_Business.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.Items.ItemEvent;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.repository.ItemsRepository;

@Service("inventoryService")
@ComponentScan("com.commerce.app.COMMERCE_Domain.repository")
public class InventoryEventHandler implements InventoryService{
	
	private static Logger LOG = LoggerFactory.getLogger(InventoryEventHandler.class);
	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	Query inventoryQuery;

	public ItemEvent addItem(ItemEvent addItemEvent) {
		Inventories inventories = addItemEvent.getItemsDetails().fromItemsDetails();
		inventories= itemsRepository.addItem(inventories);
		return new ItemEvent(inventories);
	}
	
	public ItemEvent updateItem(ItemEvent updateItemEvent) {
		Inventories inventories = updateItemEvent.getItemsDetails().fromItemsDetails();
		inventories = itemsRepository.updateItem(inventories);
		return new ItemEvent(inventories);
	}
	
	public boolean deleteItem(ItemEvent deleteItemEvent) {
		boolean deleted = false;
		Inventories inventories = deleteItemEvent.getItemsDetails().fromItemsDetails();
		deleted = itemsRepository.deleteItem(inventories);
		return deleted;
	}
	
	public ItemEvent getItem(ItemEvent getItemsEvent) {
		Inventories inventories = getItemsEvent.getItemsDetails().fromItemsDetails();
		inventories = itemsRepository.getItem(inventories);
		
		return new ItemEvent(inventories);
	}
	
	@Override
	public ItemEvent getItems(ItemEvent getItemsEvent) {
		//Might need more work done to this
		Inventories inventories = getItemsEvent.getItemsDetails().fromItemsDetails();
		ArrayList<Inventories> inventoriesArrayList = itemsRepository.getItems(inventories);
		
		return new ItemEvent(inventoriesArrayList);
	}
	
	public ItemEvent getItemsbyCategory(ItemEvent getItemsEvent) {
		//Will need more work done to this
		Inventories inventories = getItemsEvent.getItemsDetails().fromItemsDetails();
		ArrayList<Inventories> inventoriesArrayList = itemsRepository.getItemsbyCategory(inventories);
		
		return new ItemEvent(inventoriesArrayList);
	}
	
	public ItemEvent bookmarkItem(ItemEvent bookMarkItemEvent) {
		//Create a bookmark table for this. Each row will hold a list of inventory items or a link to that item.
		Inventories inventories = bookMarkItemEvent.getItemsDetails().fromItemsDetails();
		inventories = itemsRepository.bookmarkItem(inventories);
		
		return new ItemEvent(inventories);
	}
}
