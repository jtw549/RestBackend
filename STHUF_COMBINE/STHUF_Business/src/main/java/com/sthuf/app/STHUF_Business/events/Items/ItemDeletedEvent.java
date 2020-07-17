package com.sthuf.app.STHUF_Business.events.Items;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.DeletedEvent;
import com.sthuf.app.STHUF_Domain.domain.Inventories;

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
