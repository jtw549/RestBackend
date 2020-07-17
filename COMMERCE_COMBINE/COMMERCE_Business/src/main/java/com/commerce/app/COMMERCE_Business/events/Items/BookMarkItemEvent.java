package com.commerce.app.COMMERCE_Business.events.Items;

import com.commerce.app.COMMERCE_Business.events.CreateEvent;

public class BookMarkItemEvent extends CreateEvent{
/*	"items": {
    "itemId": ""
}*/
	private ItemsDetails itemsDetails;

	public ItemsDetails getItemsDetails() {
		return itemsDetails;
	}
	
	public BookMarkItemEvent (ItemsDetails itemsDetails) {
		this.itemsDetails = itemsDetails;
	}
}
