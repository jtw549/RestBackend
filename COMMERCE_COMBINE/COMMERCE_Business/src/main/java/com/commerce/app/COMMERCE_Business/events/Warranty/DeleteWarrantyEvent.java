package com.commerce.app.COMMERCE_Business.events.Warranty;

import com.commerce.app.COMMERCE_Business.events.DeleteEvent;

public class DeleteWarrantyEvent extends DeleteEvent{
	/* "warranty": {
    "warrantyId": ""
}*/
	
	private WarrantyDetails warrantyDetails;

	public WarrantyDetails getWarrantyDetails() {
		return warrantyDetails;
	}
	
	public DeleteWarrantyEvent(WarrantyDetails warrantyDetails) {
		this.warrantyDetails = warrantyDetails;
	}
}
