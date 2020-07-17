package com.commerce.app.COMMERCE_Business.events.Tags;

import com.commerce.app.COMMERCE_Business.events.UpdatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryTags;

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
