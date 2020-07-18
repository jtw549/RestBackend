package com.commerce.app.COMMERCE_WebService.rest.controller;

/*import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;*/

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.commerce.app.COMMERCE_Business.events.AppAuth.AppAuthenticatedEvent;
import com.commerce.app.COMMERCE_Business.events.AppAuth.AuthenticateAppEvent;
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
import com.commerce.app.COMMERCE_Business.services.AppAuthenticationService;
import com.commerce.app.COMMERCE_Business.services.InventoryService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Inventories;

@Controller
@RequestMapping("/api/action/items")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class InventoryController {
	
	private static Logger LOG = LoggerFactory.getLogger(InventoryController.class);

	@Autowired
	private InventoryService inventoryService;
	@Autowired
    private AppAuthenticationService appAuthenticationService;
	
	@RequestMapping(value="/addItem",method = RequestMethod.POST)
	public ResponseEntity<Inventories> addItem(@RequestParam("data")@RequestBody Inventories inventories, UriComponentsBuilder builder,
			@RequestParam("file") MultipartFile file) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Inventories>(inventories, HttpStatus.FORBIDDEN);
    	}*/
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
	
	@RequestMapping(value="/updateItem",method = RequestMethod.PUT)
	public ResponseEntity<Inventories> updateItem(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Inventories>(inventories, HttpStatus.FORBIDDEN);
    	}*/
		ItemUpdatedEvent itemUpdatedEvent = inventoryService.updateItem(new UpdateItemEvent(inventories.toItemsDetails()));
		Inventories updatedInventories = inventories.fromItemsDetails(itemUpdatedEvent.getItemsDetails()); 
		return new ResponseEntity<Inventories>(updatedInventories,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/deleteItem",method = RequestMethod.DELETE)
	public ResponseEntity<Inventories> deleteItem(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Inventories>(inventories, HttpStatus.FORBIDDEN);
    	}*/
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
	
	@RequestMapping(value="/getItem",method = RequestMethod.GET)
	public ResponseEntity<Inventories> getItem(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Inventories>(inventories, HttpStatus.FORBIDDEN);
    	}*/
		ItemGottenEvent itemGottenEvent = inventoryService.getItem(new GetItemsEvent(inventories.toItemsDetails()));
		Inventories gotInventories = inventories.fromItemsDetails(itemGottenEvent.getItemsDetails());
		return new ResponseEntity<Inventories>(gotInventories,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getItems",method = RequestMethod.GET)
	public ResponseEntity<Inventories> getItems(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Inventories>(inventories, HttpStatus.FORBIDDEN);
    	}*/
    	try {
		ItemGottenEvent itemsGottenEvent = inventoryService.getItems(new GetItemsEvent(inventories.toItemsDetails()));
		Inventories gotInventories = inventories.fromItemsDetails(itemsGottenEvent.getItemsDetails());
		return new ResponseEntity<Inventories>(gotInventories,HttpStatus.OK);
    	}catch(Exception ex) {
    		LOG.error(ex.toString());
    		return new ResponseEntity<Inventories>(HttpStatus.EXPECTATION_FAILED);
    	}
		
		
		
	}
	
	@RequestMapping(value="/getItemsbyCategory",method = RequestMethod.GET)
	public ResponseEntity<Inventories> getItemsbyCategory(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Inventories>(inventories, HttpStatus.FORBIDDEN);
    	}*/
		ItemGottenEvent itemsbyCatGottenEvent = inventoryService.getItemsbyCategory((new GetItemsEvent(inventories.toItemsDetails())));
		Inventories gotInventories = inventories.fromItemsDetails(itemsbyCatGottenEvent.getItemsDetails());
		return new ResponseEntity<Inventories>(gotInventories,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/boomarkItem",method = RequestMethod.POST)
	public ResponseEntity<Inventories> bookmarkItem(@RequestBody Inventories inventories, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Inventories>(inventories, HttpStatus.FORBIDDEN);
    	}*/
		ItemBookMarkedEvent itemBookMarkedEvent = inventoryService.bookmarkItem(new BookMarkItemEvent(inventories.toItemsDetails()));
		Inventories bookmarkedInventories = inventories.fromItemsDetails(itemBookMarkedEvent.getItemsDetails());
		return new ResponseEntity<Inventories>(bookmarkedInventories,HttpStatus.OK);
		
	}
}
