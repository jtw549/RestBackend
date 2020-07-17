package com.sthuf.app.STHUF_Business.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sthuf.app.STHUF_Business.events.Warranty.*;
import com.sthuf.app.STHUF_Domain.domain.Inventories;
import com.sthuf.app.STHUF_Domain.domain.InventoryWarranty;
import com.sthuf.app.STHUF_Domain.domain.UserCategories;
import com.sthuf.app.STHUF_Domain.repository.WarrantyRepository;

@Service("warrantyService")
@ComponentScan("com.sthuf.app.STHUF_Domain.repository")
public class WarrantyEventHandler implements WarrantyService{

	private static Logger LOG = LoggerFactory.getLogger(WarrantyEventHandler.class);

	@Autowired
	private WarrantyRepository warrantyRepository;
	
	
	@Override
	public WarrantyAddedEvent addWarranty(AddWarrantyEvent addWarrantyEvent) {
		InventoryWarranty inventoryWarranty = addWarrantyEvent.getWarrantyDetails().fromWarrantyDetails();
		ArrayList<InventoryWarranty> warranties = warrantyRepository.addWarranty(inventoryWarranty);
		return new WarrantyAddedEvent(warranties);
	}
	
	@Override
	public WarrantyDeletedEvent deleteWarranty(DeleteWarrantyEvent deleteWarrantyEvent) {
		InventoryWarranty inventoryWarranty = deleteWarrantyEvent.getWarrantyDetails().fromWarrantyDetails();
		ArrayList<InventoryWarranty> warranties = warrantyRepository.deleteWarranty(inventoryWarranty);
		return new WarrantyDeletedEvent(warranties);
	}
	
	@Override// here just in case
	public WarrantyGottenEvent getWarranty(GetWarrantyEvent getWarrantyEvent) {
		InventoryWarranty inventoryWarranty = getWarrantyEvent.getWarrantyDetails().fromWarrantyDetails();
		ArrayList<InventoryWarranty> warranties = warrantyRepository.getWarranty(inventoryWarranty);
		return new WarrantyGottenEvent(inventoryWarranty);
	}
	
	@Override
	public WarrantyUpdatedEvent updateWarranty(UpdateWarrantyEvent updateWarrantyEvent) {
		InventoryWarranty inventoryWarranty = updateWarrantyEvent.getWarrantyDetails().fromWarrantyDetails();
		ArrayList<InventoryWarranty> warranties = warrantyRepository.updateWarranty(inventoryWarranty);
		return new WarrantyUpdatedEvent(warranties);
	}
}
