package com.sthuf.app.STHUF_Domain.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InventoryWarranty {

	@Id
	private int inventoryWarrantyid;
	
	private int inventoryId;
	
	private String issuer;
	
	private int length;
	
	private String type;
	
	private Address contactAddress;
	
	private String contactPhone;
	
	private String notes;
	
	private int userId;

	public InventoryWarranty() {
		
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public int getInventoryWarrantyid() {
		return inventoryWarrantyid;
	}

	public void setInventoryWarrantyid(int inventoryWarrantyid) {
		this.inventoryWarrantyid = inventoryWarrantyid;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Address getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(Address contactAddress) {
		this.contactAddress = contactAddress;
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
}
