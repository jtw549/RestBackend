package com.sthuf.app.STHUF_Business.events.Media;

import com.sthuf.app.STHUF_Business.events.CreateEvent;

public class AddMediaEvent extends CreateEvent{

	private MediaDetails mediaDetails;

	public MediaDetails getMediaDetails() {
		return mediaDetails;
	}
	
	public AddMediaEvent (MediaDetails mediaDetails) {
		this.mediaDetails = mediaDetails;
	}
}
