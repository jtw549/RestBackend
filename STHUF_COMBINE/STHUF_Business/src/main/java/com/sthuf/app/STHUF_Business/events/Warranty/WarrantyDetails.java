package com.sthuf.app.STHUF_Business.events.Warranty;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Domain.domain.Address;
import com.sthuf.app.STHUF_Domain.domain.InventoryWarranty;

public class WarrantyDetails {

	private int inventoryWarrantyId;
	
	private int inventoryId;
	
	private String issuer;
	
	private int length;
	
	private String type;
	
	private Address contactAddress;
	
	private String contactPhone;
	
	private String notes;
	
	private int userId;
	
	private ArrayList<InventoryWarranty> inventoryWarranties;
	
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	
	public WarrantyDetails toWarrantyDetails
	(ArrayList<InventoryWarranty> inventoryWarranty,WarrantyDetails warrantyDetails) {
		warrantyDetails.setInventoryWarranties(inventoryWarranty);
		return warrantyDetails;
	}
	public WarrantyDetails toWarrantyDetails(InventoryWarranty inventoryWarranty,WarrantyDetails warrantyDetails) {
		warrantyDetails.setContactAddress(inventoryWarranty.getContactAddress());
		warrantyDetails.setInventoryId(inventoryWarranty.getInventoryId());
		warrantyDetails.setInventoryWarrantyId(inventoryWarranty.getInventoryWarrantyid());
		warrantyDetails.setIssuer(inventoryWarranty.getIssuer());
		warrantyDetails.setNotes(inventoryWarranty.getNotes());
		warrantyDetails.setType(inventoryWarranty.getType());
		warrantyDetails.setContactPhone(inventoryWarranty.getContactPhone());
		warrantyDetails.setLength(inventoryWarranty.getLength());
		warrantyDetails.setUserId(inventoryWarranty.getUserId());
		return warrantyDetails;
	}
	
	public InventoryWarranty fromWarrantyDetails() {
		InventoryWarranty inventoryWarranty = new InventoryWarranty();
		inventoryWarranty.setContactAddress(contactAddress);
		inventoryWarranty.setContactPhone(contactPhone);
		inventoryWarranty.setIssuer(issuer);
		inventoryWarranty.setNotes(notes);
		inventoryWarranty.setType(type);
		inventoryWarranty.setInventoryId(inventoryId);
		inventoryWarranty.setUserId(userId);
		inventoryWarranty.setLength(length);
		inventoryWarranty.setInventoryWarrantyid(inventoryWarrantyId);
		return inventoryWarranty;
	}

	public ArrayList<InventoryWarranty> getInventoryWarranties() {
		return inventoryWarranties;
	}

	public void setInventoryWarranties(ArrayList<InventoryWarranty> inventoryWarranties) {
		this.inventoryWarranties = inventoryWarranties;
	}
	
}
