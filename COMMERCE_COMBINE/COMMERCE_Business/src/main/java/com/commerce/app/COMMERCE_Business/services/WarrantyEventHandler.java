package com.commerce.app.COMMERCE_Business.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.Warranty.*;
import com.commerce.app.COMMERCE_Domain.domain.InventoryWarranty;
import com.commerce.app.COMMERCE_Domain.repository.WarrantyRepository;

@Service("warrantyService")
@ComponentScan("com.commerce.app.COMMERCE_Domain.repository")
public class WarrantyEventHandler implements WarrantyService{

	private static Logger LOG = LoggerFactory.getLogger(WarrantyEventHandler.class);

	@Autowired
	private WarrantyRepository warrantyRepository;
	
	
	public WarrantyEvent addWarranty(WarrantyEvent addWarrantyEvent) {
		InventoryWarranty inventoryWarranty = addWarrantyEvent.getWarrantyDetails().fromWarrantyDetails();
		ArrayList<InventoryWarranty> warranties = warrantyRepository.addWarranty(inventoryWarranty);
		return  new WarrantyEvent(warranties);
	}
	
	public boolean deleteWarranty(WarrantyEvent deleteWarrantyEvent) {
		InventoryWarranty inventoryWarranty = deleteWarrantyEvent.getWarrantyDetails().fromWarrantyDetails();
		boolean deletedWarranty = warrantyRepository.deleteWarranty(inventoryWarranty);
		return deletedWarranty;
	}
	
	public WarrantyEvent getWarranty(WarrantyEvent getWarrantyEvent) {
		InventoryWarranty inventoryWarranty = getWarrantyEvent.getWarrantyDetails().fromWarrantyDetails();
		ArrayList<InventoryWarranty> warranties = warrantyRepository.getWarranty(inventoryWarranty);
		return new WarrantyEvent(warranties);
	}
	
	public WarrantyEvent updateWarranty(WarrantyEvent updateWarrantyEvent) {
		InventoryWarranty inventoryWarranty = updateWarrantyEvent.getWarrantyDetails().fromWarrantyDetails();
		ArrayList<InventoryWarranty> warranties = warrantyRepository.updateWarranty(inventoryWarranty);
		return new WarrantyEvent(warranties);
	}
}
