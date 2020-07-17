package com.sthuf.app.STHUF_Business.services;

import com.sthuf.app.STHUF_Business.events.Warranty.*;

public interface WarrantyService {

	public WarrantyAddedEvent addWarranty(AddWarrantyEvent addWarrantyEvent);
	public WarrantyDeletedEvent deleteWarranty(DeleteWarrantyEvent deleteWarrantyEvent);
	public WarrantyGottenEvent getWarranty(GetWarrantyEvent getWarrantyEvent);
	public WarrantyUpdatedEvent updateWarranty(UpdateWarrantyEvent updateWarrantyEvent);
}
