package com.commerce.app.COMMERCE_Business.events.Warranty;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.UpdatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty;

public class WarrantyUpdatedEvent extends UpdatedEvent{
	/*  "status": "",
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
	
	public WarrantyUpdatedEvent(ArrayList<InventoryWarranty> inventoryWarranty) {
		WarrantyDetails warrantyDetails = new WarrantyDetails();
		warrantyDetails.toWarrantyDetails(inventoryWarranty,warrantyDetails);
		this.warrantyDetails = warrantyDetails;
	}
}
