package com.sthuf.app.STHUF_Business.events.Items;

import com.sthuf.app.STHUF_Business.events.CreateEvent;

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
