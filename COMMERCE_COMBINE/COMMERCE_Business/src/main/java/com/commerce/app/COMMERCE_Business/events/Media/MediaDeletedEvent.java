package com.commerce.app.COMMERCE_Business.events.Media;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.DeletedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryMedia;

public class MediaDeletedEvent extends DeletedEvent{
	
	private final MediaDetails mediaDetails = new MediaDetails();
	
	private boolean deletionCompleted;

	public boolean isDeletionCompleted() {
		return deletionCompleted;
	}

	public MediaDeletedEvent (boolean deleted) {
		deletionCompleted = deleted;
	}
	
	public MediaDetails getMediaDetails() {
		return mediaDetails;
	}
	
	/*public MediaDeletedEvent (ArrayList<InventoryMedia> inventoryMedia) {
		MediaDetails mediaDetails = new MediaDetails();
		mediaDetails.toMediaDetails(inventoryMedia,mediaDetails);
		this.mediaDetails = mediaDetails;
	}*/
}
