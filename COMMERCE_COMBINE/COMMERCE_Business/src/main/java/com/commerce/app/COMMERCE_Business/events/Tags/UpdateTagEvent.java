package com.commerce.app.COMMERCE_Business.events.Tags;

import com.commerce.app.COMMERCE_Business.events.UpdateEvent;

public class UpdateTagEvent extends UpdateEvent{
	private TagDetails tagDetails;

	public TagDetails getTagDetails() {
		return tagDetails;
	}
	
	public UpdateTagEvent (TagDetails tagDetails) {
		this.tagDetails = tagDetails;
	}
}
