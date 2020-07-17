package com.commerce.app.COMMERCE_Business.events.Warranty;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;

public class GetWarrantyEvent extends ReadEvent{
	
	private WarrantyDetails warrantyDetails;

	public WarrantyDetails getWarrantyDetails() {
		return warrantyDetails;
	}
	
	public GetWarrantyEvent(WarrantyDetails warrantyDetails) {
		this.warrantyDetails = warrantyDetails;
	}
}
