package com.commerce.app.COMMERCE_Business.events.Warranty;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty;

public class WarrantyGottenEvent extends ReadEvent{

	private final WarrantyDetails warrantyDetails;

	public WarrantyDetails getWarrantyDetails() {
		return warrantyDetails;
	}
	
	public WarrantyGottenEvent(InventoryWarranty inventoryWarranty) {
		WarrantyDetails warrantyDetails = new WarrantyDetails();
		warrantyDetails.toWarrantyDetails(inventoryWarranty,warrantyDetails);
		this.warrantyDetails = warrantyDetails;
	}
}
