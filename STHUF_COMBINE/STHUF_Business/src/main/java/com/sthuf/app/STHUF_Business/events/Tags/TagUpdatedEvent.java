package com.sthuf.app.STHUF_Business.events.Tags;

import com.sthuf.app.STHUF_Business.events.UpdatedEvent;
import com.sthuf.app.STHUF_Domain.domain.InventoryTags;

public class TagUpdatedEvent extends UpdatedEvent{

	private final TagDetails tagDetails;

	public TagDetails getTagDetails() {
		return tagDetails;
	}
	
	public TagUpdatedEvent (InventoryTags inventoryTags) {
		TagDetails tagDetails = new TagDetails();
		tagDetails.toTagDetails(inventoryTags);
		this.tagDetails = tagDetails;
	}
}
