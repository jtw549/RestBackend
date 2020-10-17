package com.commerce.app.COMMERCE_Business.events.Tags;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.InventoryTags;

public class TagEvent {

	private TagDetails tagDetails;

	public TagDetails getTagDetails() {
		return tagDetails;
	}
	
	public TagEvent (TagDetails tagDetails) {
		this.tagDetails = tagDetails;
	}
	
	public TagEvent (ArrayList<InventoryTags> inventoryTags) {
	TagDetails tagDetails = new TagDetails();
	tagDetails.toTagDetails(inventoryTags);
	this.tagDetails = tagDetails;
	}

	public TagEvent (InventoryTags inventoryTags) {
		TagDetails tagDetails = new TagDetails();
		tagDetails.toTagDetails(inventoryTags);
		this.tagDetails = tagDetails;
	}

}
