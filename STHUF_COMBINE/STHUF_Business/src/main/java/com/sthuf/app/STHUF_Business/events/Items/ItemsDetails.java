package com.sthuf.app.STHUF_Business.events.Items;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Domain.domain.*;

public class ItemsDetails {

	private int userId;
	
	private int inventoryId;
	
	private int categoryId;
	
	private int userCategoryId;
	
	private String make;
	
	private String name;
	
	private String serialNumber;
	
	private String seller;
	
	private String price;
	
	private String purchaseDate;
	
	private String model;
	
	private int quantity;
	
	private ArrayList<String> conditions; 
	
	private int likes;
	
	private String privacy;
	
	private String shareLink;
	
	private String shareEmbed;
	
	private ArrayList<InventoryWarranty> inventoryWarranty;
	
	private ArrayList<InventoryComments> inventoryComments;
	
	private ArrayList<InventoryNotes> inventoryNotes;
	
	private ArrayList<InventoryTags> inventoryTags;
	
	private ArrayList<InventoryMedia> inventoryMedias;

	private String updatedDate;
	
	private String createdDate;
	
	private ArrayList<com.sthuf.app.STHUF_Domain.domain.Inventories> inventoriesList;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArrayList<String> getConditions() {
		return conditions;
	}

	public void setConditions(ArrayList<String> conditions) {
		this.conditions = conditions;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getShareLink() {
		return shareLink;
	}

	public void setShareLink(String shareLink) {
		this.shareLink = shareLink;
	}

	public String getShareEmbed() {
		return shareEmbed;
	}

	public void setShareEmbed(String shareEmbed) {
		this.shareEmbed = shareEmbed;
	}

	public ArrayList<InventoryWarranty> getInventoryWarranty() {
		return inventoryWarranty;
	}

	public void setInventoryWarranty(ArrayList<InventoryWarranty> inventoryWarranty) {
		this.inventoryWarranty = inventoryWarranty;
	}

	public ArrayList<InventoryComments> getInventoryComments() {
		return inventoryComments;
	}

	public void setInventoryComments(ArrayList<InventoryComments> inventoryComments) {
		this.inventoryComments = inventoryComments;
	}

	public ArrayList<InventoryNotes> getInventoryNotes() {
		return inventoryNotes;
	}

	public void setInventoryNotes(ArrayList<InventoryNotes> inventoryNotes) {
		this.inventoryNotes = inventoryNotes;
	}

	public ArrayList<InventoryTags> getInventoryTags() {
		return inventoryTags;
	}

	public void setInventoryTags(ArrayList<InventoryTags> inventoryTags) {
		this.inventoryTags = inventoryTags;
	}

	public ArrayList<InventoryMedia> getInventoryMedias() {
		return inventoryMedias;
	}

	public void setInventoryMedias(ArrayList<InventoryMedia> inventoryMedias) {
		this.inventoryMedias = inventoryMedias;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public int getUserCategoryId() {
		return userCategoryId;
	}

	public void setUserCategoryId(int userCategoryId) {
		this.userCategoryId = userCategoryId;
	}
	
	public ItemsDetails toItemsDetails (ArrayList<Inventories> inventories,ItemsDetails itemsDetails) {
		itemsDetails.setInventoriesList(inventories);
		return itemsDetails;
	}
	public ItemsDetails toItemsDetails (Inventories inventories,ItemsDetails itemsDetails) {
		itemsDetails.setUserId(inventories.getUserId());
		itemsDetails.setCategoryId(inventories.getCategoryId());
		itemsDetails.setConditions(inventories.getConditions());
		itemsDetails.setCreatedDate(inventories.getCreatedDate());
		itemsDetails.setInventoryComments(inventories.getInventoryComments());
		itemsDetails.setInventoryId(inventories.getInventoryId());
		itemsDetails.setInventoryMedias(inventories.getInventoryMedias());
		itemsDetails.setInventoryNotes(inventories.getInventoryNotes());
		itemsDetails.setInventoryTags(inventories.getInventoryTags());
		itemsDetails.setInventoryWarranty(inventories.getInventoryWarranty());
		itemsDetails.setLikes(inventories.getLikes());
		itemsDetails.setMake(inventories.getMake());
		itemsDetails.setModel(inventories.getModel());
		itemsDetails.setName(inventories.getName());
		itemsDetails.setPrice(inventories.getPrice());
		itemsDetails.setPurchaseDate(inventories.getPurchaseDate());
		itemsDetails.setQuantity(inventories.getQuantity());
		itemsDetails.setSeller(inventories.getSeller());
		itemsDetails.setSerialNumber(inventories.getSerialNumber());
		itemsDetails.setShareEmbed(inventories.getShareEmbed());
		itemsDetails.setShareLink(inventories.getShareLink());
		itemsDetails.setUpdatedDate(inventories.getUpdatedDate());
		itemsDetails.setUserCategoryId(inventories.getCategoryId());
		return itemsDetails;
	}
	
	public Inventories fromItemsDetails() {
		Inventories inventories = new Inventories();
		inventories.setUserId(userId);
		inventories.setCategoryId(categoryId);
		inventories.setConditions(conditions);
		inventories.setCreatedDate(createdDate);
		inventories.setPurchaseDate(purchaseDate);
		inventories.setUpdatedDate(updatedDate);
		inventories.setInventoryComments(inventoryComments);
		inventories.setInventoryId(inventoryId);
		inventories.setLikes(likes);
		inventories.setPrice(price);
		inventories.setQuantity(quantity);
		inventories.setUserCategoryId(userCategoryId);
		inventories.setInventoryMedias(inventoryMedias);
		inventories.setInventoryNotes(inventoryNotes);
		inventories.setInventoryTags(inventoryTags);
		inventories.setInventoryWarranty(inventoryWarranty);
		inventories.setMake(make);
		inventories.setModel(model);
		inventories.setName(name);
		inventories.setPrivacy(privacy);
		inventories.setSeller(seller);
		inventories.setSerialNumber(serialNumber);
		inventories.setShareEmbed(shareEmbed);
		inventories.setShareLink(shareLink);
		return inventories;
		
	}

	public ArrayList<com.sthuf.app.STHUF_Domain.domain.Inventories> getInventoriesList() {
		return inventoriesList;
	}

	public void setInventoriesList(ArrayList<com.sthuf.app.STHUF_Domain.domain.Inventories> inventoriesList) {
		this.inventoriesList = inventoriesList;
	}
}
