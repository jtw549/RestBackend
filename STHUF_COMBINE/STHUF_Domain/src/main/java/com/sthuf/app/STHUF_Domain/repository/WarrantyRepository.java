package com.sthuf.app.STHUF_Domain.repository;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Domain.domain.InventoryWarranty;

public interface WarrantyRepository {

	public ArrayList<InventoryWarranty> addWarranty(InventoryWarranty inventoryWarranty);
	public ArrayList<InventoryWarranty> deleteWarranty(InventoryWarranty inventoryWarranty);
	public ArrayList<InventoryWarranty> updateWarranty(InventoryWarranty inventoryWarranty);
	public ArrayList<InventoryWarranty> getWarranty(InventoryWarranty inventoryWarranty);
}
