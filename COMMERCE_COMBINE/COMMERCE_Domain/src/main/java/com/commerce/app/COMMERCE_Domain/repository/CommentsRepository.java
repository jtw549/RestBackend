package com.commerce.app.COMMERCE_Domain.repository;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.InventoryComments;


public interface CommentsRepository{

	
	public ArrayList<InventoryComments> addComments(InventoryComments inventoryComments);
	public ArrayList<InventoryComments> deleteComments(InventoryComments inventoryComments);
	public ArrayList<InventoryComments> updateComments(InventoryComments inventoryComments);
	public ArrayList<InventoryComments> getComments(InventoryComments inventoryComments);
}
