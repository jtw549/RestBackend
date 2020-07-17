package com.commerce.app.COMMERCE_Domain.repository;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty;

public interface WarrantyRepository {

	public ArrayList<InventoryWarranty> addWarranty(InventoryWarranty inventoryWarranty);
	public ArrayList<InventoryWarranty> deleteWarranty(InventoryWarranty inventoryWarranty);
	public ArrayList<InventoryWarranty> updateWarranty(InventoryWarranty inventoryWarranty);
	public ArrayList<InventoryWarranty> getWarranty(InventoryWarranty inventoryWarranty);
}
