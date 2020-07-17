package com.sthuf.app.STHUF_Business.events.Warranty;

import com.sthuf.app.STHUF_Business.events.DeleteEvent;

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
