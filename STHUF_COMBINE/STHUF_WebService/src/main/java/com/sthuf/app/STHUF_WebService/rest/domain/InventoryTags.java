package com.sthuf.app.STHUF_WebService.rest.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.sthuf.app.STHUF_Business.events.Tags.TagDetails;

@XmlRootElement
public class InventoryTags implements Serializable{

	private int position;
	
	private String formula;
	
	private int inventoryTagsId;
	
	private int inventoryId;
	
	private String tagName;
	
	private int userId;
	
	public TagDetails toTagDetails() {
		TagDetails tagDetails = new TagDetails();
		tagDetails.setInventoryId(inventoryId);
		tagDetails.setInventoryTagsId(inventoryTagsId);
		tagDetails.setTagName(tagName);
		tagDetails.setUserId(userId);
		return tagDetails;
	}
	
	public InventoryTags fromTagDetails(TagDetails tagDetails) {
		InventoryTags inventoryTags = new InventoryTags();
		inventoryTags.inventoryId=tagDetails.getInventoryId();
		inventoryTags.inventoryTagsId=tagDetails.getInventoryTagsId();
		inventoryTags.userId=tagDetails.getUserId();
		inventoryTags.tagName=tagDetails.getTagName();
		return inventoryTags;
	}
	
	public ArrayList<String> appVerify(){
		ArrayList<String> appValues = new ArrayList<String>();
		appValues.add(formula);
		appValues.add(String.valueOf(position));
		return appValues;
		
	}
}
