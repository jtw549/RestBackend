package com.sthuf.app.STHUF_Domain.repository;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Domain.domain.InventoryMedia;

public interface MediaRepository {

	public ArrayList<InventoryMedia> addMedias(InventoryMedia inventoryMedia);
	
	public boolean deleteMedias(InventoryMedia inventoryMedia);
}
