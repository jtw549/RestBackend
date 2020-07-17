package com.sthuf.app.STHUF_Business.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.sthuf.app.STHUF_Business.events.Items.*;
import com.sthuf.app.STHUF_Domain.domain.Inventories;
import com.sthuf.app.STHUF_Domain.repository.ItemsRepository;

@Service("inventoryService")
@ComponentScan("com.sthuf.app.STHUF_Domain.repository")
public class InventoryEventHandler implements InventoryService{
	
	private static Logger LOG = LoggerFactory.getLogger(InventoryEventHandler.class);
	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	Query inventoryQuery;
	@Override
	public ItemAddedEvent addItem(AddItemEvent addItemEvent) {
		Inventories inventories = addItemEvent.getItemsDetails().fromItemsDetails();
		inventories= itemsRepository.addItem(inventories);
		return new ItemAddedEvent(inventories);
	}
	
	@Override
	public ItemUpdatedEvent updateItem(UpdateItemEvent updateItemEvent) {
		Inventories inventories = updateItemEvent.getItemsDetails().fromItemsDetails();
		inventories = itemsRepository.updateItem(inventories);
		return new ItemUpdatedEvent(inventories);
	}
	
	@Override
	public ItemDeletedEvent deleteItem(DeleteItemEvent deleteItemEvent) {
		boolean deleted = false;
		Inventories inventories = deleteItemEvent.getItemsDetails().fromItemsDetails();
		deleted = itemsRepository.deleteItem(inventories);
		return new ItemDeletedEvent(deleted);
	}
	
	@Override
	public ItemGottenEvent getItem(GetItemsEvent getItemsEvent) {
		Inventories inventories = getItemsEvent.getItemsDetails().fromItemsDetails();
		inventories = itemsRepository.getItem(inventories);
		
		return new ItemGottenEvent(inventories);
	}
	
	@Override
	public ItemGottenEvent getItems(GetItemsEvent getItemsEvent) {
		//Might need more work done to this
		Inventories inventories = getItemsEvent.getItemsDetails().fromItemsDetails();
		ArrayList<Inventories> inventoriesArrayList = itemsRepository.getItems(inventories);
		
		return new ItemGottenEvent(inventoriesArrayList);
	}
	
	@Override
	public ItemGottenEvent getItemsbyCategory(GetItemsEvent getItemsEvent) {
		//Will need more work done to this
		Inventories inventories = getItemsEvent.getItemsDetails().fromItemsDetails();
		ArrayList<Inventories> inventoriesArrayList = itemsRepository.getItemsbyCategory(inventories);
		
		return new ItemGottenEvent(inventoriesArrayList);
	}
	
	@Override
	public ItemBookMarkedEvent bookmarkItem(BookMarkItemEvent bookMarkItemEvent) {
		//Create a bookmark table for this. Each row will hold a list of inventory items or a link to that item.
		Inventories inventories = bookMarkItemEvent.getItemsDetails().fromItemsDetails();
		inventories = itemsRepository.bookmarkItem(inventories);
		
		return new ItemBookMarkedEvent(inventories);
	}
}
