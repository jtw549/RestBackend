package com.commerce.app.COMMERCE_Business.events.Media;


public class AddMediaEvent{

	private MediaDetails mediaDetails;

	public MediaDetails getMediaDetails() {
		return mediaDetails;
	}
	
	public AddMediaEvent (MediaDetails mediaDetails) {
		this.mediaDetails = mediaDetails;
	}
	
	/*public MediaDeletedEvent (ArrayList<InventoryMedia> inventoryMedia) {
	MediaDetails mediaDetails = new MediaDetails();
	mediaDetails.toMediaDetails(inventoryMedia,mediaDetails);
	this.mediaDetails = mediaDetails;
}*/
}
