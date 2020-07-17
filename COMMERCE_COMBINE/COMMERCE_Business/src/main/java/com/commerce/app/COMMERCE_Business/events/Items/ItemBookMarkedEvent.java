package com.commerce.app.COMMERCE_Business.events.Items;

import com.commerce.app.COMMERCE_Business.events.CreatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;

public class ItemBookMarkedEvent extends CreatedEvent{

	/* "status": "",
	    "message": ""*/
	
	private final ItemsDetails itemsDetails;
	
	public ItemsDetails getItemsDetails() {
		return itemsDetails;
	}

	public ItemBookMarkedEvent(Inventories inventories) {
		ItemsDetails itemsDetails = new ItemsDetails();
		itemsDetails.toItemsDetails(inventories,itemsDetails);
		this.itemsDetails = itemsDetails;
	}
}
