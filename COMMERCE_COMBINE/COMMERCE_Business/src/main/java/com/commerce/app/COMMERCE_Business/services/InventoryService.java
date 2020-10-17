package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Items.*;

public interface InventoryService {

	public ItemEvent addItem(ItemEvent addItemEvent);
	public ItemEvent updateItem(ItemEvent updateItemEvent);
	public boolean deleteItem(ItemEvent deleteItemEvent);
	public ItemEvent getItem(ItemEvent getItemsEvent);
	public ItemEvent getItems(ItemEvent getItemsEvent);
	public ItemEvent getItemsbyCategory(ItemEvent getItemsEvent);
	public ItemEvent bookmarkItem(ItemEvent bookMarkItemEvent);
}
