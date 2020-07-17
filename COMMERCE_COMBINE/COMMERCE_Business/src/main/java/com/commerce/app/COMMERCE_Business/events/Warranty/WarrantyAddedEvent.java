package com.commerce.app.COMMERCE_Business.events.Warranty;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.CreatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty;

public class WarrantyAddedEvent extends CreatedEvent{
	 /*"status": "",
	    "message": "",
	    "warranty": {
	        "warrantyId": "",
	        "issuer": "",
	        "length": "",
	        "contactInfo": "",
	        "notes": ""
	    }*/
	private final WarrantyDetails warrantyDetails;

	public WarrantyDetails getWarrantyDetails() {
		return warrantyDetails;
	}
	
	public WarrantyAddedEvent(ArrayList<InventoryWarranty> inventoryWarranty) {
		WarrantyDetails warrantyDetails = new WarrantyDetails();
		warrantyDetails.toWarrantyDetails(inventoryWarranty,warrantyDetails);
		this.warrantyDetails = warrantyDetails;
	}
}
