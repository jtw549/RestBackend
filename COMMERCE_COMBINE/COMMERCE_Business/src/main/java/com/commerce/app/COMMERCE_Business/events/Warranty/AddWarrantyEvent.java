package com.commerce.app.COMMERCE_Business.events.Warranty;

import com.commerce.app.COMMERCE_Business.events.CreateEvent;

public class AddWarrantyEvent extends CreateEvent{
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
	
	public AddWarrantyEvent(WarrantyDetails warrantyDetails) {
		this.warrantyDetails = warrantyDetails;
	}
}
