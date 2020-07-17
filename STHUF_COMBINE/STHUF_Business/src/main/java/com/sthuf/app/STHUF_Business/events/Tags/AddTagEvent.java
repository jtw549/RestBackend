package com.sthuf.app.STHUF_Business.events.Tags;

import com.sthuf.app.STHUF_Business.events.CreateEvent;

public class AddTagEvent extends CreateEvent{

	private TagDetails tagDetails;

	public TagDetails getTagDetails() {
		return tagDetails;
	}
	
	public AddTagEvent (TagDetails tagDetails) {
		this.tagDetails = tagDetails;
	}
}
