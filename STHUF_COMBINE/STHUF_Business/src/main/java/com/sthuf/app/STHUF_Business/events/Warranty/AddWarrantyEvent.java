package com.sthuf.app.STHUF_Business.events.Warranty;

import com.sthuf.app.STHUF_Business.events.CreateEvent;

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
