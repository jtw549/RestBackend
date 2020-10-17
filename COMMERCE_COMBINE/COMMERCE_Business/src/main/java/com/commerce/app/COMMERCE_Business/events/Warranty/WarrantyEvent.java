package com.commerce.app.COMMERCE_Business.events.Warranty;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty;

public class WarrantyEvent {
	/* "warranty": {
    "itemId": "",
    "issuer": "",
    "length": "",
    "contactInfo": "",
    "notes": ""
}*/
	
	private WarrantyDetails warrantyDetails;

	public WarrantyDetails getWarrantyDetails() {
		return warrantyDetails;
	}
	
	public WarrantyEvent(WarrantyDetails warrantyDetails) {
		this.warrantyDetails = warrantyDetails;
	}
	
	public WarrantyEvent(ArrayList<InventoryWarranty> inventoryWarranty) {
		WarrantyDetails warrantyDetails = new WarrantyDetails();
		warrantyDetails.toWarrantyDetails(inventoryWarranty,warrantyDetails);
		this.warrantyDetails = warrantyDetails;
	}
}
