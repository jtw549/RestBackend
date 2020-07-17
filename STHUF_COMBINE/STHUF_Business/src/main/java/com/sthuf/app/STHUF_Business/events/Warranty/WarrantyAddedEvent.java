package com.sthuf.app.STHUF_Business.events.Warranty;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.CreatedEvent;
import com.sthuf.app.STHUF_Domain.domain.InventoryWarranty;

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
