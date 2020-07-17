package com.commerce.app.COMMERCE_Business.events.Warranty;

import com.commerce.app.COMMERCE_Business.events.UpdateEvent;

public class UpdateWarrantyEvent extends UpdateEvent{
	/* "warranty": {
    "warrantyId": "",
    "issuer": "",
    "length": "",
    "contactInfo": "",
    "notes": ""
}*/
	private WarrantyDetails warrantyDetails;

	public WarrantyDetails getWarrantyDetails() {
		return warrantyDetails;
	}
	
	public UpdateWarrantyEvent(WarrantyDetails warrantyDetails) {
		this.warrantyDetails = warrantyDetails;
	}
}
