package com.sthuf.app.STHUF_Business.events.Warranty;

import com.sthuf.app.STHUF_Business.events.UpdateEvent;

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
