package com.commerce.app.COMMERCE_Domain.domain;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "InventoryTags")
public class InventoryTags {

	@Id
	private int inventoryTagsId;
	
	private int inventoryId;
	
	private String tagName;
	
	private int userId;
	
	private ArrayList<Integer> inventoryIdArrayList;
	
	public InventoryTags() {
		
	}

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

	public ArrayList<Integer> getInventoryIdArrayList() {
		return inventoryIdArrayList;
	}

	public void setInventoryIdArrayList(ArrayList<Integer> inventoryIdArrayList) {
		this.inventoryIdArrayList = inventoryIdArrayList;
	}
}
