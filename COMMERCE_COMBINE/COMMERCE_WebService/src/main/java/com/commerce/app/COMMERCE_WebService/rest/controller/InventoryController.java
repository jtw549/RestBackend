package com.commerce.app.COMMERCE_WebService.rest.controller;

import java.io.File;

/*import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.commerce.app.COMMERCE_Business.events.Items.AddItemEvent;
import com.commerce.app.COMMERCE_Business.events.Items.BookMarkItemEvent;
import com.commerce.app.COMMERCE_Business.events.Items.DeleteItemEvent;
import com.commerce.app.COMMERCE_Business.events.Items.GetItemsEvent;
import com.commerce.app.COMMERCE_Business.events.Items.ItemAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Items.ItemBookMarkedEvent;
import com.commerce.app.COMMERCE_Business.events.Items.ItemDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Items.ItemGottenEvent;
import com.commerce.app.COMMERCE_Business.events.Items.ItemUpdatedEvent;
import com.commerce.app.COMMERCE_Business.events.Items.UpdateItemEvent;
import com.commerce.app.COMMERCE_Business.services.InventoryService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Inventories;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "InventoryRestController", description = "REST API for handling all inventory")
@RestController
@RequestMapping("/api/action/items")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class InventoryController {
	
	private static Logger LOG = LoggerFactory.getLogger(InventoryController.class);

	@Autowired
	private InventoryService inventoryService;
	
	  @ApiOperation(value = "Add an Inventory", tags = "addInventory")
			@ApiResponses(value = { 
			            @ApiResponse(code = 201, message = "Created"),
			            @ApiResponse(code = 401, message = "Not authorized"), 
			            @ApiResponse(code = 403, message = "Forbidden")
			        })
	@RequestMapping(value="/addItem",method = RequestMethod.PUT)
	public ResponseEntity<Inventories> addItem(@RequestParam("data")@RequestBody Inventories inventories, UriComponentsBuilder builder,
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
            try {
            	
            	  File convFile = new File( file.getOriginalFilename());
            	  file.transferTo(convFile);
            	 // inventories.set
              /*  byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();*/
            } catch (Exception e) {
            }
        } else {
        	
        }
		
		ItemAddedEvent itemAddedEvent = inventoryService.addItem(new AddItemEvent(inventories.toItemsDetails()));
		Inventories newInventories = inventories.fromItemsDetails(itemAddedEvent.getItemsDetails());
		
		return new ResponseEntity<Inventories>(newInventories,HttpStatus.CREATED);
		
	}
	
	  @ApiOperation(value = "Updates an Inventory", tags = "updatesInventory")
			@ApiResponses(value = { 
			            @ApiResponse(code = 200, message = "Success|OK"),
			            @ApiResponse(code = 401, message = "Not authorized"), 
			           })
	@RequestMapping(value="/updateItem",method = RequestMethod.POST)
	public ResponseEntity<Inventories> updateItem(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		ItemUpdatedEvent itemUpdatedEvent = inventoryService.updateItem(new UpdateItemEvent(inventories.toItemsDetails()));
		Inventories updatedInventories = inventories.fromItemsDetails(itemUpdatedEvent.getItemsDetails()); 
		return new ResponseEntity<Inventories>(updatedInventories,HttpStatus.OK);
		
	}
	
	  @ApiOperation(value = "Deletes an Inventory", tags = "deleteInventory")
			@ApiResponses(value = { 
			            @ApiResponse(code = 200, message = "Success|OK"),
			            @ApiResponse(code = 401, message = "Not authorized"), 
			            @ApiResponse(code = 403, message = "Forbidden"),
			            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/deleteItem",method = RequestMethod.DELETE)
	public ResponseEntity<Inventories> deleteItem(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		ItemDeletedEvent itemDeletedEvent = inventoryService.deleteItem(new DeleteItemEvent(inventories.toItemsDetails()));
		Inventories deletedInventories = inventories.fromItemsDetails(itemDeletedEvent.getItemsDetails()); 
		
		   if (!itemDeletedEvent.isEntityFound()) {
	            return new ResponseEntity<Inventories>(HttpStatus.NOT_FOUND);
	        }
	        if (itemDeletedEvent.isDeletionCompleted()) {
	            return new ResponseEntity<Inventories>(deletedInventories, HttpStatus.OK);
	        }
		return new ResponseEntity<Inventories>(deletedInventories,HttpStatus.FORBIDDEN);
		
	}
	
	  @ApiOperation(value = "Get an Inventory", response=Inventories.class,tags = "getInventory")
			@ApiResponses(value = { 
			            @ApiResponse(code = 200, message = "Success|OK"),
			            @ApiResponse(code = 401, message = "Not authorized"), 
			            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/getItem",method = RequestMethod.GET)
	public ResponseEntity<Inventories> getItem(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		ItemGottenEvent itemGottenEvent = inventoryService.getItem(new GetItemsEvent(inventories.toItemsDetails()));
		Inventories gotInventories = inventories.fromItemsDetails(itemGottenEvent.getItemsDetails());
		return new ResponseEntity<Inventories>(gotInventories,HttpStatus.OK);
		
	}
	
	  @ApiOperation(value = "Gets an Inventories", response=Inventories.class,tags = "getInventories")
			@ApiResponses(value = { 
			            @ApiResponse(code = 200, message = "Success|OK"),
			            @ApiResponse(code = 401, message = "Not authorized"),
			            @ApiResponse(code = 417, message = "Expectation Failed"),
			            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/getItems",method = RequestMethod.GET)
	public ResponseEntity<Inventories> getItems(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
    	try {
		ItemGottenEvent itemsGottenEvent = inventoryService.getItems(new GetItemsEvent(inventories.toItemsDetails()));
		Inventories gotInventories = inventories.fromItemsDetails(itemsGottenEvent.getItemsDetails());
		return new ResponseEntity<Inventories>(gotInventories,HttpStatus.OK);
    	}catch(Exception ex) {
    		LOG.error(ex.toString());
    		return new ResponseEntity<Inventories>(HttpStatus.EXPECTATION_FAILED);
    	}
		
		
		
	}
	  @ApiOperation(value = "Gets Inventories by Category", response=Inventories.class,tags = "getByCategoryInventories")
			@ApiResponses(value = { 
			            @ApiResponse(code = 200, message = "Success|OK"),
			            @ApiResponse(code = 401, message = "Not authorized"), 
			            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/getItemsbyCategory",method = RequestMethod.GET)
	public ResponseEntity<Inventories> getItemsbyCategory(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		ItemGottenEvent itemsbyCatGottenEvent = inventoryService.getItemsbyCategory((new GetItemsEvent(inventories.toItemsDetails())));
		Inventories gotInventories = inventories.fromItemsDetails(itemsbyCatGottenEvent.getItemsDetails());
		return new ResponseEntity<Inventories>(gotInventories,HttpStatus.OK);
		
	}
	
	  @ApiOperation(value = "Bookmarks an Inventory", tags = "bookmarkInventory")
			@ApiResponses(value = { 
			            @ApiResponse(code = 200, message = "Success|OK"),
			            @ApiResponse(code = 401, message = "Not authorized")
			             })
	@RequestMapping(value="/boomarkItem",method = RequestMethod.POST)
	public ResponseEntity<Inventories> bookmarkItem(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		ItemBookMarkedEvent itemBookMarkedEvent = inventoryService.bookmarkItem(new BookMarkItemEvent(inventories.toItemsDetails()));
		Inventories bookmarkedInventories = inventories.fromItemsDetails(itemBookMarkedEvent.getItemsDetails());
		return new ResponseEntity<Inventories>(bookmarkedInventories,HttpStatus.OK);
		
	}
}
