package com.commerce.app.COMMERCE_Business.events.Items;

import com.commerce.app.COMMERCE_Business.events.CreatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;

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
