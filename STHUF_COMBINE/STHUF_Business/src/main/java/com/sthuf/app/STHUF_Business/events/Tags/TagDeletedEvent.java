package com.sthuf.app.STHUF_Business.events.Tags;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.DeletedEvent;
import com.sthuf.app.STHUF_Domain.domain.InventoryTags;

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
