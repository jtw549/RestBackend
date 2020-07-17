package com.sthuf.app.STHUF_Business.events.Items;

import com.sthuf.app.STHUF_Business.events.CreateEvent;

public class AddItemEvent extends CreateEvent{
/*	"item": {
    "userId": "3489EAGFOJG489UPGAJREP",
    "make": "",
    "name": "",
    "categories": [
        {
            "id": ""
        },
        ...
    ]
}*/
	private ItemsDetails itemsDetails;

	public ItemsDetails getItemsDetails() {
		return itemsDetails;
	}
	
	public AddItemEvent (ItemsDetails itemsDetails) {
		this.itemsDetails = itemsDetails;
	}
}
