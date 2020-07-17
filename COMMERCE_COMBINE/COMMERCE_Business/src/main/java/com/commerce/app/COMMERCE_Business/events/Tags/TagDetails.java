package com.commerce.app.COMMERCE_Business.events.Tags;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.InventoryTags;

public class TagDetails {
	
	private int inventoryTagsId;

	private int inventoryId;
	
	private String tagName;
	
	private int userId;
	
	private ArrayList<InventoryTags> inventoryTags;
	
	public int getInventoryTagsId() {
		return inventoryTagsId;
	}

	public void setInventoryTagsId(int inventoryTagsId) {
		this.inventoryTagsId = inventoryTagsId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public TagDetails toTagDetails(ArrayList<InventoryTags> inventoryTags) {
		TagDetails tagDetails = new TagDetails();
		tagDetails.setInventoryTags(inventoryTags);
		return tagDetails;
	}
	
	public TagDetails toTagDetails(InventoryTags inventoryTags) {
		TagDetails tagDetails = new TagDetails();
		tagDetails.setInventoryId(inventoryTags.getInventoryId());
		tagDetails.setInventoryTagsId(inventoryTags.getInventoryTagsId());
		tagDetails.setTagName(inventoryTags.getTagName());
		tagDetails.setUserId(inventoryTags.getUserId());
		return tagDetails;
	}
	
	public InventoryTags fromTagDetails() {
		InventoryTags inventoryTags = new InventoryTags();
		inventoryTags.setInventoryId(inventoryId);
		inventoryTags.setInventoryTagsId(inventoryTagsId);
		inventoryTags.setUserId(userId);
		inventoryTags.setTagName(tagName);
		return inventoryTags;
	}

	public ArrayList<InventoryTags> getInventoryTags() {
		return inventoryTags;
	}

	public void setInventoryTags(ArrayList<InventoryTags> inventoryTags) {
		this.inventoryTags = inventoryTags;
	}
}