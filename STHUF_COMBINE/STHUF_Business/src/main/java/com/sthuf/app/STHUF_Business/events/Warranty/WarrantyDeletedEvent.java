package com.sthuf.app.STHUF_Business.events.Warranty;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.DeletedEvent;
import com.sthuf.app.STHUF_Domain.domain.InventoryWarranty;

public class WarrantyDeletedEvent extends DeletedEvent{

   /* "status": "",
    "message": ""*/
	
	private final WarrantyDetails warrantyDetails;
	
	private boolean deletionCompleted;

	public WarrantyDetails getWarrantyDetails() {
		return warrantyDetails;
	}
	
	public WarrantyDeletedEvent(ArrayList<InventoryWarranty> inventoryWarranty) {
		WarrantyDetails warrantyDetails = new WarrantyDetails();
		warrantyDetails.toWarrantyDetails(inventoryWarranty,warrantyDetails);
		this.warrantyDetails = warrantyDetails;
	}
	
	 public boolean isDeletionCompleted() {
		    return deletionCompleted;
		  }
}
