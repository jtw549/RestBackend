package com.sthuf.app.STHUF_Business.events.Items;

import com.sthuf.app.STHUF_Business.events.CreatedEvent;
import com.sthuf.app.STHUF_Domain.domain.Inventories;

public class ItemAddedEvent extends CreatedEvent{
	private final ItemsDetails itemsDetails;
	
	public ItemAddedEvent(Inventories inventories) {
		ItemsDetails itemsDetails = new ItemsDetails();
		itemsDetails.toItemsDetails(inventories,itemsDetails);
		this.itemsDetails = itemsDetails;
	}
	
	public ItemsDetails getItemsDetails() {
		return itemsDetails;
	}

	
}
