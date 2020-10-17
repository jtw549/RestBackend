package com.commerce.app.COMMERCE_Business.events.Media;


public class MediaEvent{

	private MediaDetails mediaDetails;

	public MediaDetails getMediaDetails() {
		return mediaDetails;
	}
	
	public MediaEvent (MediaDetails mediaDetails) {
		this.mediaDetails = mediaDetails;
	}
	
	/*public MediaDeletedEvent (ArrayList<InventoryMedia> inventoryMedia) {
	MediaDetails mediaDetails = new MediaDetails();
	mediaDetails.toMediaDetails(inventoryMedia,mediaDetails);
	this.mediaDetails = mediaDetails;
}*/
}
