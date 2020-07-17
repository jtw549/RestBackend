package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Items.*;

public interface InventoryService {

	public ItemAddedEvent addItem(AddItemEvent addItemEvent);
	public ItemUpdatedEvent updateItem(UpdateItemEvent updateItemEvent);
	public ItemDeletedEvent deleteItem(DeleteItemEvent deleteItemEvent);
	public ItemGottenEvent getItem(GetItemsEvent getItemsEvent);
	public ItemGottenEvent getItems(GetItemsEvent getItemsEvent);
	public ItemGottenEvent getItemsbyCategory(GetItemsEvent getItemsEvent);
	public ItemBookMarkedEvent bookmarkItem(BookMarkItemEvent bookMarkItemEvent);
}
