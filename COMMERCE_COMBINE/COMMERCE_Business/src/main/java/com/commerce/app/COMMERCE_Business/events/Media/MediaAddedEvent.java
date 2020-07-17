package com.commerce.app.COMMERCE_Business.events.Media;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.CreatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryMedia;

public class MediaAddedEvent extends CreatedEvent{
	private final MediaDetails mediaDetails;

	public MediaDetails getMediaDetails() {
		return mediaDetails;
	}
	
	public MediaAddedEvent (ArrayList<InventoryMedia> inventoryMedia) {
		MediaDetails mediaDetails = new MediaDetails();
		mediaDetails.toMediaDetails(inventoryMedia,mediaDetails);
		this.mediaDetails = mediaDetails;
	}
}
