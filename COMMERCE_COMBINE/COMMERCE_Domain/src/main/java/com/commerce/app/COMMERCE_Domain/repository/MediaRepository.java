package com.commerce.app.COMMERCE_Domain.repository;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.InventoryMedia;

public interface MediaRepository {

	public ArrayList<InventoryMedia> addMedias(InventoryMedia inventoryMedia);
	
	public boolean deleteMedias(InventoryMedia inventoryMedia);
}
