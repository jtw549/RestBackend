package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Tags.TagDetails;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class InventoryTags implements Serializable{
	@ApiModelProperty(notes = "Inventory tags id",name="inventoryTagsId",required=true,value="test inventory tags id")
	private int inventoryTagsId;
	
	@ApiModelProperty(notes = "Inventory id associated with the tag",name="inventoryId",required=true,value="test inventory id")
	private int inventoryId;
	
	@ApiModelProperty(notes = "Inventory tag name",name="tagName",required=true,value="test inventory tag name")
	private String tagName;
	
	@ApiModelProperty(notes = "Inventory tags user id associated with the tags",name="userId",required=true,value="test inventory tags user id")
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
}
