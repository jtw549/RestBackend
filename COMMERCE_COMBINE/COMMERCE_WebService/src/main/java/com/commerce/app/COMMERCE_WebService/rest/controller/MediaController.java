package com.commerce.app.COMMERCE_WebService.rest.controller;

/*import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.commerce.app.COMMERCE_Business.events.Media.AddMediaEvent;
import com.commerce.app.COMMERCE_Business.events.Media.DeleteMediaEvent;
import com.commerce.app.COMMERCE_Business.events.Media.MediaAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Media.MediaDeletedEvent;
import com.commerce.app.COMMERCE_Business.services.AppAuthenticationService;
import com.commerce.app.COMMERCE_Business.services.MediaService;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryMedia;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/api/action/media")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class MediaController {

	private static Logger LOG = LoggerFactory.getLogger(MediaController.class);
	
	@Autowired
	private MediaService mediaService;
	@Autowired
    private AppAuthenticationService appAuthenticationService;
	
	@RequestMapping(value="/addMedia",method = RequestMethod.POST)
	public ResponseEntity<InventoryMedia> addMedia (@RequestParam("data")@RequestBody InventoryMedia inventoryMedia , UriComponentsBuilder builder,
			@RequestParam(value="file", required=false) MultipartFile file) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Inventories>(inventories, HttpStatus.FORBIDDEN);
    	}*/
		if (!file.isEmpty()) {
            try {
            	 File convFile = new File( file.getOriginalFilename());
           	  	 file.transferTo(convFile);
           	  	 inventoryMedia.setMediaFile(convFile);
            } catch (Exception e) {
            	
            }
        } 
		
		MediaAddedEvent mediaAddedEvent =mediaService.addMedia(new AddMediaEvent(inventoryMedia.toMediaDetails()));
		InventoryMedia newInventoryMedia = inventoryMedia.fromMediaDetails(mediaAddedEvent.getMediaDetails());
		
		return new ResponseEntity<InventoryMedia>(newInventoryMedia,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/deleteMedia",method = RequestMethod.DELETE)
	public ResponseEntity<InventoryMedia> deleteMedia (@RequestBody InventoryMedia inventoryMedia, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Inventories>(inventories, HttpStatus.FORBIDDEN);
    	}*/
		MediaDeletedEvent mediaDeletedEvent = mediaService.deleteMedia(new DeleteMediaEvent(inventoryMedia.toMediaDetails()));
		InventoryMedia newInventoryMedia = inventoryMedia.fromMediaDetails(mediaDeletedEvent.getMediaDetails());
		
		return new ResponseEntity<InventoryMedia>(newInventoryMedia,HttpStatus.OK);
	}
}
