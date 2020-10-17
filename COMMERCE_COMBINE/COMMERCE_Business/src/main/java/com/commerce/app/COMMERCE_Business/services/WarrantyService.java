package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyEvent;

public interface WarrantyService {

	public WarrantyEvent addWarranty(WarrantyEvent addWarrantyEvent);
	public boolean deleteWarranty(WarrantyEvent deleteWarrantyEvent);
	public WarrantyEvent getWarranty(WarrantyEvent getWarrantyEvent);
	public WarrantyEvent updateWarranty(WarrantyEvent updateWarrantyEvent);
}
