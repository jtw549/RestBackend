package com.commerce.app.COMMERCE_WebService.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.commerce.app.COMMERCE_Business.events.AppAuth.AppAuthenticatedEvent;
import com.commerce.app.COMMERCE_Business.events.AppAuth.AuthenticateAppEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.AddWarrantyEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.DeleteWarrantyEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.GetWarrantyEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.UpdateWarrantyEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyGottenEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyUpdatedEvent;
import com.commerce.app.COMMERCE_Business.services.AppAuthenticationService;
import com.commerce.app.COMMERCE_Business.services.WarrantyService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Inventories;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryWarranty;
import com.commerce.app.COMMERCE_WebService.rest.domain.Users;

@Controller
@RequestMapping("/api/action/warranties")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class WarrantyController {
	private static Logger LOG = LoggerFactory.getLogger(WarrantyController.class);
	@Autowired
	private WarrantyService warrantyService;
	@Autowired
    private AppAuthenticationService appAuthenticationService;
	
	@RequestMapping(value="/addWarranty",method = RequestMethod.POST)
	public ResponseEntity<InventoryWarranty> addWarranty(@RequestBody InventoryWarranty inventoryWarranty, UriComponentsBuilder builder) {
	/*	AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryWarranty.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryWarranty>(inventoryWarranty, HttpStatus.FORBIDDEN);
    	}*/
		WarrantyAddedEvent warrantyAddedEvent = warrantyService.addWarranty(new AddWarrantyEvent(inventoryWarranty.toWarrantyDetails()));
		InventoryWarranty addedInventoryWarranty = inventoryWarranty.fromWarrantyDetails(warrantyAddedEvent.getWarrantyDetails());
    	
		return new ResponseEntity<InventoryWarranty>(addedInventoryWarranty, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/updateWarranty",method = RequestMethod.PUT)
	public ResponseEntity<InventoryWarranty> updateWarranty(@RequestBody InventoryWarranty inventoryWarranty, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryWarranty.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryWarranty>(inventoryWarranty, HttpStatus.FORBIDDEN);
    	}*/
		WarrantyUpdatedEvent warrantyUpdatedEvent = warrantyService.updateWarranty(new UpdateWarrantyEvent(inventoryWarranty.toWarrantyDetails()));
    	InventoryWarranty updatedInventoryWarranty = inventoryWarranty.fromWarrantyDetails(warrantyUpdatedEvent.getWarrantyDetails());
		
		return new ResponseEntity<InventoryWarranty>(updatedInventoryWarranty, HttpStatus.OK);
		
	}
	

	@RequestMapping(value="/deleteWarranty",method = RequestMethod.DELETE)
	public ResponseEntity<InventoryWarranty> deleteWarranty(@RequestBody InventoryWarranty inventoryWarranty, UriComponentsBuilder builder) {
	/*	AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryWarranty.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryWarranty>(inventoryWarranty, HttpStatus.FORBIDDEN);
    	}*/
    	WarrantyDeletedEvent warrantyDeletedEvent = warrantyService.deleteWarranty(new DeleteWarrantyEvent(inventoryWarranty.toWarrantyDetails()));
    	InventoryWarranty deletedInventoryWarranty = inventoryWarranty.fromWarrantyDetails(warrantyDeletedEvent.getWarrantyDetails());
		
    	if (!warrantyDeletedEvent.isEntityFound()) {
            return new ResponseEntity<InventoryWarranty>(HttpStatus.NOT_FOUND);
        }
        if (warrantyDeletedEvent.isDeletionCompleted()) {
            return new ResponseEntity<InventoryWarranty>(deletedInventoryWarranty, HttpStatus.OK);
        }
        
		return new ResponseEntity<InventoryWarranty>(deletedInventoryWarranty, HttpStatus.FORBIDDEN);
		
	}
	

	@RequestMapping(value="/getWarranty",method = RequestMethod.GET)
	public ResponseEntity<InventoryWarranty> getWarranty(@RequestBody InventoryWarranty inventoryWarranty, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryWarranty.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryWarranty>(inventoryWarranty, HttpStatus.FORBIDDEN);
    	}*/
    	WarrantyGottenEvent warrantyGottenEvent = warrantyService.getWarranty(new GetWarrantyEvent(inventoryWarranty.toWarrantyDetails()));
		InventoryWarranty gottenInventoryWarranty = inventoryWarranty.fromWarrantyDetails(warrantyGottenEvent.getWarrantyDetails());
    	
		return new ResponseEntity<InventoryWarranty>(gottenInventoryWarranty, HttpStatus.OK);
		
	}
	
}
