package com.commerce.app.COMMERCE_Domain.repository;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.InventoryTags;


public interface TagsRepository {
	public InventoryTags addTag(InventoryTags inventoryTags);
	public boolean deleteTag(InventoryTags inventoryTags);
	public InventoryTags updateTag(InventoryTags inventoryTags);
	public ArrayList<InventoryTags> getTags(InventoryTags inventoryTags);
}
