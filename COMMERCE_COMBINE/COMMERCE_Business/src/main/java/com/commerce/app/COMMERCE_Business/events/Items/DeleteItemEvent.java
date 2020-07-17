package com.commerce.app.COMMERCE_Business.events.Items;

import com.commerce.app.COMMERCE_Business.events.DeleteEvent;

public class DeleteItemEvent extends DeleteEvent{
	/*"item": {
    "id": "32FE3F33FWL3FWFW3F"
}*/
	private ItemsDetails itemsDetails;

	public ItemsDetails getItemsDetails() {
		return itemsDetails;
	}
	
	public DeleteItemEvent (ItemsDetails itemsDetails) {
		this.itemsDetails = itemsDetails;
	}
}
