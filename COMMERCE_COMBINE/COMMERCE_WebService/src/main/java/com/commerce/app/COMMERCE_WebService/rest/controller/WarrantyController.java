package com.commerce.app.COMMERCE_WebService.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.DeleteWarrantyEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.GetWarrantyEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.UpdateWarrantyEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyGottenEvent;
import com.commerce.app.COMMERCE_Business.events.Warranty.WarrantyUpdatedEvent;
import com.commerce.app.COMMERCE_Business.services.WarrantyService;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryWarranty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "WarrantyRestController", description = "REST API for handling warranties for inventory")
@RestController
@RequestMapping("/api/action/warranties")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class WarrantyController {
	private static Logger LOG = LoggerFactory.getLogger(WarrantyController.class);
	@Autowired
	private WarrantyService warrantyService;

	@ApiOperation(value = "Adds a warranty associated to a Inventory and returns a list of warranties", response = InventoryWarranty.class, tags = "addWarranty")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden")
	             })
	@RequestMapping(value="/addWarranty",method = RequestMethod.POST)
	public ResponseEntity<InventoryWarranty> addWarranty(@RequestBody InventoryWarranty inventoryWarranty, UriComponentsBuilder builder) {
		WarrantyAddedEvent warrantyAddedEvent = warrantyService.addWarranty(new WarrantyEvent(inventoryWarranty.toWarrantyDetails()));
		InventoryWarranty addedInventoryWarranty = inventoryWarranty.fromWarrantyDetails(warrantyAddedEvent.getWarrantyDetails());
    	
		return new ResponseEntity<InventoryWarranty>(addedInventoryWarranty, HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value = "Updates a inventory warranty and returns a warranty", response = InventoryWarranty.class, tags = "updateWarranty")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/updateWarranty",method = RequestMethod.PUT)
	public ResponseEntity<InventoryWarranty> updateWarranty(@RequestBody InventoryWarranty inventoryWarranty, UriComponentsBuilder builder) {
		WarrantyUpdatedEvent warrantyUpdatedEvent = warrantyService.updateWarranty(new UpdateWarrantyEvent(inventoryWarranty.toWarrantyDetails()));
    	InventoryWarranty updatedInventoryWarranty = inventoryWarranty.fromWarrantyDetails(warrantyUpdatedEvent.getWarrantyDetails());
		
		return new ResponseEntity<InventoryWarranty>(updatedInventoryWarranty, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Deletes a warranty from a inventory", response = InventoryWarranty.class, tags = "deleteWarranty")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/deleteWarranty",method = RequestMethod.DELETE)
	public ResponseEntity<InventoryWarranty> deleteWarranty(@RequestBody InventoryWarranty inventoryWarranty, UriComponentsBuilder builder) {
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
	
	@ApiOperation(value = "Gets a warranty for a inventory", response = InventoryWarranty.class, tags = "getWarranty")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/getWarranty",method = RequestMethod.GET)
	public ResponseEntity<InventoryWarranty> getWarranty(@RequestBody InventoryWarranty inventoryWarranty, UriComponentsBuilder builder) {
    	WarrantyGottenEvent warrantyGottenEvent = warrantyService.getWarranty(new GetWarrantyEvent(inventoryWarranty.toWarrantyDetails()));
		InventoryWarranty gottenInventoryWarranty = inventoryWarranty.fromWarrantyDetails(warrantyGottenEvent.getWarrantyDetails());
    	
		return new ResponseEntity<InventoryWarranty>(gottenInventoryWarranty, HttpStatus.OK);
		
	}
	
}
