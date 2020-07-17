package com.sthuf.app.STHUF_Business.events.Media;

import com.sthuf.app.STHUF_Business.events.DeleteEvent;

public class DeleteMediaEvent extends DeleteEvent{
	private MediaDetails mediaDetails;

	public MediaDetails getMediaDetails() {
		return mediaDetails;
	}
	
	public DeleteMediaEvent (MediaDetails mediaDetails) {
		this.mediaDetails = mediaDetails;
	}
}
