package com.commerce.app.COMMERCE_Business.events.Items;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;

public class GetItemsEvent extends ReadEvent{
	//get item
	/* "item": {
    "id": "32FE3F33FWL3FWFW3F"
}*/
	
	
//get items	
/*	   "items": {
    "userId": "SA0IE44T4UPTVAWB5YE"
}*/
//get items by category	
	/*
	"items": {
    "userId": "",
    "categoryId": ""
}*/
	private ItemsDetails itemsDetails;

	public ItemsDetails getItemsDetails() {
		return itemsDetails;
	}
	//fix for the different get items
	public GetItemsEvent (ItemsDetails itemsDetails) {
		this.itemsDetails = itemsDetails;
	}
}
