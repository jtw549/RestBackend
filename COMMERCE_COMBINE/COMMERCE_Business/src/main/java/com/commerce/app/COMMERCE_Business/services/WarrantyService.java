package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Warranty.*;

public interface WarrantyService {

	public WarrantyAddedEvent addWarranty(AddWarrantyEvent addWarrantyEvent);
	public WarrantyDeletedEvent deleteWarranty(DeleteWarrantyEvent deleteWarrantyEvent);
	public WarrantyGottenEvent getWarranty(GetWarrantyEvent getWarrantyEvent);
	public WarrantyUpdatedEvent updateWarranty(UpdateWarrantyEvent updateWarrantyEvent);
}
