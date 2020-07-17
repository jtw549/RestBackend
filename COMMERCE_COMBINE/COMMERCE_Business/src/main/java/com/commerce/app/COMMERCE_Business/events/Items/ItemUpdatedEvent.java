package com.commerce.app.COMMERCE_Business.events.Items;

import com.commerce.app.COMMERCE_Business.events.UpdatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;

public class ItemUpdatedEvent extends UpdatedEvent{

/*	 "status": "",
	    "message": "",
	    "item": {
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
	
	private final ItemsDetails itemsDetails;
	
	public ItemsDetails getItemsDetails() {
		return itemsDetails;
	}

	public ItemUpdatedEvent(Inventories inventories) {
		ItemsDetails itemsDetails = new ItemsDetails();
		itemsDetails.toItemsDetails(inventories,itemsDetails);
		this.itemsDetails = itemsDetails;
	}
}
