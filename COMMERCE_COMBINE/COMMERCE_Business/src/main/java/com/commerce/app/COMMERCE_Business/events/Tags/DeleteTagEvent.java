package com.commerce.app.COMMERCE_Business.events.Tags;

import com.commerce.app.COMMERCE_Business.events.DeleteEvent;

public class DeleteTagEvent extends DeleteEvent{
	private TagDetails tagDetails;

	public TagDetails getTagDetails() {
		return tagDetails;
	}
	
	public DeleteTagEvent (TagDetails tagDetails) {
		this.tagDetails = tagDetails;
	}
}
