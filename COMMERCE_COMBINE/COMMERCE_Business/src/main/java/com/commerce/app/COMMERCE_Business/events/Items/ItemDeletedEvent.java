package com.commerce.app.COMMERCE_Business.events.Items;

import com.commerce.app.COMMERCE_Business.events.DeletedEvent;

public class ItemDeletedEvent extends DeletedEvent {
	
	private final ItemsDetails itemsDetails = new ItemsDetails();
	
	private boolean deletionCompleted;
	 
	public ItemsDetails getItemsDetails() {
		return itemsDetails;
	}

	public ItemDeletedEvent(boolean deleted) {
		deletionCompleted = deleted;
	}
	
	 public boolean isDeletionCompleted() {
		    return deletionCompleted;
		  }
}
