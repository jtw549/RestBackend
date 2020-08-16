package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Items.ItemsDetails;
import com.commerce.app.COMMERCE_Domain.domain.InventoryMedia;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonAutoDetect
public class Inventories implements Serializable{

	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="userId")
	private int userId;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="inventoryId")
	private int inventoryId;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="categoryId")
	private int categoryId;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="userCategoryId")
	private int userCategoryId;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="make")
	private String make;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="name")
	private String name;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="serialNumber")
	private String serialNumber;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="seller")
	private String seller;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="price")
	private String price;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="purchaseDate")
	private String purchaseDate;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="model")
	private String model;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="quantity")
	private int quantity;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="conditions")
	private ArrayList<String> conditions; 
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="likes")
	private int likes;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="privacy")
	private String privacy;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="shareLink")
	private String shareLink;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="shareEmbed")
	private String shareEmbed;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="inventoryWarranty")
	private ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty> inventoryWarranty;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="inventoryComments")
	private ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryComments> inventoryComments;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="inventoryNotes")
	private ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryNotes> inventoryNotes;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="inventoryTags")
	private ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryTags> inventoryTags;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="inventoryMedias")
	private ArrayList<InventoryMedia> inventoryMedias;

	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="updatedDate")
	private String updatedDate;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="createdDate")
	private String createdDate;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	@JsonProperty(value="inventoriesList")
	private ArrayList<com.commerce.app.COMMERCE_Domain.domain.Inventories> inventoriesList;
	
	
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

	public int getUserCategoryId() {
		return userCategoryId;
	}

	public void setUserCategoryId(int userCategoryId) {
		this.userCategoryId = userCategoryId;
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

	public ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty> getInventoryWarranty() {
		return inventoryWarranty;
	}

	public void setInventoryWarranty(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty> inventoryWarranty) {
		this.inventoryWarranty = inventoryWarranty;
	}

	public ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryComments> getInventoryComments() {
		return inventoryComments;
	}

	public void setInventoryComments(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryComments> inventoryComments) {
		this.inventoryComments = inventoryComments;
	}

	public ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryNotes> getInventoryNotes() {
		return inventoryNotes;
	}

	public void setInventoryNotes(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryNotes> inventoryNotes) {
		this.inventoryNotes = inventoryNotes;
	}

	public ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryTags> getInventoryTags() {
		return inventoryTags;
	}

	public void setInventoryTags(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryTags> inventoryTags) {
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

	public ArrayList<com.commerce.app.COMMERCE_Domain.domain.Inventories> getInventoriesList() {
		return inventoriesList;
	}

	public void setInventoriesList(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.Inventories> inventoriesList) {
		this.inventoriesList = inventoriesList;
	}

	public ItemsDetails toItemsDetails () {
		ItemsDetails itemsDetails = new ItemsDetails();
		itemsDetails.setUserId(userId);
		itemsDetails.setCategoryId(categoryId);
		itemsDetails.setConditions(conditions);
		itemsDetails.setCreatedDate(createdDate);
		itemsDetails.setInventoryComments(inventoryComments);
		itemsDetails.setInventoryId(inventoryId);
		itemsDetails.setInventoryMedias(inventoryMedias);
		itemsDetails.setInventoryNotes(inventoryNotes);
		itemsDetails.setInventoryTags(inventoryTags);
		itemsDetails.setInventoryWarranty(inventoryWarranty);
		itemsDetails.setLikes(likes);
		itemsDetails.setMake(make);
		itemsDetails.setModel(model);
		itemsDetails.setName(name);
		itemsDetails.setPrice(price);
		itemsDetails.setPurchaseDate(purchaseDate);
		itemsDetails.setQuantity(quantity);
		itemsDetails.setSeller(seller);
		itemsDetails.setSerialNumber(serialNumber);
		itemsDetails.setShareEmbed(shareEmbed);
		itemsDetails.setShareLink(shareLink);
		itemsDetails.setUpdatedDate(updatedDate);
		itemsDetails.setUserCategoryId(userCategoryId);
		return itemsDetails;
	}
	
	public Inventories fromItemsDetails (ItemsDetails itemsDetails) {
		Inventories inventories = new Inventories();
		inventories.userId=itemsDetails.getUserId();
		inventories.categoryId= itemsDetails.getCategoryId();
		inventories.conditions=itemsDetails.getConditions();
		inventories.createdDate=itemsDetails.getCreatedDate();
		inventories.purchaseDate=itemsDetails.getPurchaseDate();
		inventories.updatedDate=itemsDetails.getUpdatedDate();
		inventories.inventoryComments=itemsDetails.getInventoryComments();
		inventories.inventoryId=itemsDetails.getInventoryId();
		inventories.likes=itemsDetails.getLikes();
		inventories.price=itemsDetails.getPrice();
		inventories.quantity=itemsDetails.getQuantity();
		inventories.userCategoryId=itemsDetails.getUserCategoryId();
		inventories.inventoryMedias=itemsDetails.getInventoryMedias();
		inventories.inventoryNotes=itemsDetails.getInventoryNotes();
		inventories.inventoryTags=itemsDetails.getInventoryTags();
		inventories.inventoryWarranty=itemsDetails.getInventoryWarranty();
		inventories.make=itemsDetails.getMake();
		inventories.model=itemsDetails.getModel();
		inventories.name=itemsDetails.getName();
		inventories.privacy=itemsDetails.getPrivacy();
		inventories.seller=itemsDetails.getSeller();
		inventories.serialNumber=itemsDetails.getSerialNumber();
		inventories.shareEmbed=itemsDetails.getShareEmbed();
		inventories.shareLink=itemsDetails.getShareLink();
		inventories.inventoriesList=itemsDetails.getInventoriesList();
		return inventories;
		
	}
}
