package com.commerce.app.COMMERCE_Business.events.Items;

import com.commerce.app.COMMERCE_Business.events.UpdateEvent;

public class UpdateItemEvent extends UpdateEvent{
	/* "item": {
    "id": "32FKLJRWLKJRLK3JLKFSDF",
    "make": "Apple",
    "inventoryName": "iPad Air",
    "seller": "Apple Store",
    "cost": "499.99",
    "purchaseDate": "",
    "quantity": "1",
    "dateAdded": "",
    "itemLikes": "",
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
	//fix for the different get items
	public UpdateItemEvent (ItemsDetails itemsDetails) {
		this.itemsDetails = itemsDetails;
	}
}
