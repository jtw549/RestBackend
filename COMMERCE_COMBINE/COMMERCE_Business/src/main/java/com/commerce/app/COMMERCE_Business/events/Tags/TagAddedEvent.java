package com.commerce.app.COMMERCE_Business.events.Tags;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.CreatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryTags;

public class TagAddedEvent extends CreatedEvent{
	private final TagDetails tagDetails;

	public TagDetails getTagDetails() {
		return tagDetails;
	}
	
	public TagAddedEvent (ArrayList<InventoryTags> inventoryTags) {
		TagDetails tagDetails = new TagDetails();
		tagDetails.toTagDetails(inventoryTags);
		this.tagDetails = tagDetails;
	}
}
