package com.sthuf.app.STHUF_Business.events.Warranty;

import com.sthuf.app.STHUF_Business.events.ReadEvent;

public class GetWarrantyEvent extends ReadEvent{
	
	private WarrantyDetails warrantyDetails;

	public WarrantyDetails getWarrantyDetails() {
		return warrantyDetails;
	}
	
	public GetWarrantyEvent(WarrantyDetails warrantyDetails) {
		this.warrantyDetails = warrantyDetails;
	}
}
