package com.commerce.app.COMMERCE_Business.events.Items;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.DeletedEvent;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;

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
