package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
@JsonAutoDetect
public class InventoryWarranty implements Serializable{

	@ApiModelProperty(notes = "Inventory warranty id",name="inventoryWarrantyId",required=true,value="test inventory warranty id")
	@JsonProperty(value="inventoryWarrantyId")
	private int inventoryWarrantyId;
	
	@ApiModelProperty(notes = "Inventory warranty associated with inventory id",name="inventoryId",required=true,value="test inventory warranty inventory id")
	@JsonProperty(value="inventoryId")
	private int inventoryId;
	
	@ApiModelProperty(notes = "Inventory warranty issuer",name="issuer",required=true,value="test inventory warranty issuer")
	@JsonProperty(value="issuer")
	private String issuer;
	
	@ApiModelProperty(notes = "Inventory warranty length",name="length",required=true,value="test inventory warranty length")
	@JsonProperty(value="length")
	private int length;
	
	@ApiModelProperty(notes = "Inventory warranty type",name="type",required=true,value="test inventory warranty type")
	@JsonProperty(value="type")
	private String type;
	
	@ApiModelProperty(notes = "Inventory warranty contact address",name="contactAddress",required=true,value="test inventory warranty contact address")
	@JsonProperty(value="contactAddress")
	private com.commerce.app.COMMERCE_Domain.domain.Address contactAddress;
	
	@ApiModelProperty(notes = "Inventory warranty contact phone number",name="contactPhone",required=true,value="test inventory warranty contact phone number")
	@JsonProperty(value="contactPhone")
	private String contactPhone;
	
	@ApiModelProperty(notes = "Inventory warranty notes",name="notes",required=true,value="test inventory warranty notes")
	@JsonProperty(value="notes")
	private String notes;
	
	@ApiModelProperty(notes = "Inventory warranty user id associated with the warranties",name="userId",required=true,value="test inventory warranty user id")
	@JsonProperty(value="userId")
	private int userId;
	
	@ApiModelProperty(notes = "Inventory warranty list associated with inventory",name="inventoryWarrantyList",required=true,value="test inventory warranty list")
	@JsonProperty(value="inventoryWarrantyList")
	private ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty> inventoryWarrantyList;
	
	public WarrantyDetails toWarrantyDetails() {
		WarrantyDetails warrantyDetails = new WarrantyDetails();
		warrantyDetails.setContactAddress(contactAddress);
		warrantyDetails.setInventoryId(inventoryId);
		warrantyDetails.setInventoryWarrantyId(inventoryWarrantyId);
		warrantyDetails.setIssuer(issuer);
		warrantyDetails.setNotes(notes);
		warrantyDetails.setType(type);
		warrantyDetails.setContactPhone(contactPhone);
		warrantyDetails.setLength(length);
		warrantyDetails.setUserId(userId);
		return warrantyDetails;
	}
	
	public InventoryWarranty fromWarrantyDetails(WarrantyDetails warrantyDetails) {
		InventoryWarranty inventoryWarranty = new InventoryWarranty();
		inventoryWarranty.contactAddress=warrantyDetails.getContactAddress();
		inventoryWarranty.contactPhone=warrantyDetails.getContactPhone();
		inventoryWarranty.issuer=warrantyDetails.getIssuer();
		inventoryWarranty.notes=warrantyDetails.getNotes();
		inventoryWarranty.type=warrantyDetails.getType();
		inventoryWarranty.inventoryId=warrantyDetails.getInventoryId();
		inventoryWarranty.userId=warrantyDetails.getUserId();
		inventoryWarranty.length=warrantyDetails.getLength();
		inventoryWarranty.inventoryWarrantyId=warrantyDetails.getInventoryWarrantyId();
		return inventoryWarranty;
	}
	
	
	public int getInventoryWarrantyId() {
		return inventoryWarrantyId;
	}

	public void setInventoryWarrantyId(int inventoryWarrantyId) {
		this.inventoryWarrantyId = inventoryWarrantyId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public com.commerce.app.COMMERCE_Domain.domain.Address getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(
			com.commerce.app.COMMERCE_Domain.domain.Address contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty> getInventoryWarranty() {
		return inventoryWarrantyList;
	}

	public void setInventoryWarranty(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty> inventoryWarranty) {
		this.inventoryWarrantyList = inventoryWarranty;
	}
}
