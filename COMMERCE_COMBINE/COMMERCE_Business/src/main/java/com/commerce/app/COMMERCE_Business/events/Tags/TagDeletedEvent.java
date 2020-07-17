package com.commerce.app.COMMERCE_Business.events.Tags;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.DeletedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryTags;

public class TagDeletedEvent extends DeletedEvent{
	private final TagDetails tagDetails;

	public TagDetails getTagDetails() {
		return tagDetails;
	}
	
	public TagDeletedEvent (ArrayList<InventoryTags> inventoryTags) {
		TagDetails tagDetails = new TagDetails();
		tagDetails.toTagDetails(inventoryTags);
		this.tagDetails = tagDetails;
	}
}
