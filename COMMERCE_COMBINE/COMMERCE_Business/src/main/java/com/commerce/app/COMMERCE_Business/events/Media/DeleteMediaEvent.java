package com.commerce.app.COMMERCE_Business.events.Media;

import com.commerce.app.COMMERCE_Business.events.DeleteEvent;

public class DeleteMediaEvent extends DeleteEvent{
	private MediaDetails mediaDetails;

	public MediaDetails getMediaDetails() {
		return mediaDetails;
	}
	
	public DeleteMediaEvent (MediaDetails mediaDetails) {
		this.mediaDetails = mediaDetails;
	}
}
