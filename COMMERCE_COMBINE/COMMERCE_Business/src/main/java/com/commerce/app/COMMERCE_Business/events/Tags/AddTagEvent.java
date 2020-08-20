package com.commerce.app.COMMERCE_Business.events.Tags;


public class AddTagEvent {

	private TagDetails tagDetails;

	public TagDetails getTagDetails() {
		return tagDetails;
	}
	
	public AddTagEvent (TagDetails tagDetails) {
		this.tagDetails = tagDetails;
	}
	
	/*public TagAddedEvent (ArrayList<InventoryTags> inventoryTags) {
	TagDetails tagDetails = new TagDetails();
	tagDetails.toTagDetails(inventoryTags);
	this.tagDetails = tagDetails;
	}

	public TagUpdatedEvent (InventoryTags inventoryTags) {
		TagDetails tagDetails = new TagDetails();
		tagDetails.toTagDetails(inventoryTags);
		this.tagDetails = tagDetails;
	}
*/
}
