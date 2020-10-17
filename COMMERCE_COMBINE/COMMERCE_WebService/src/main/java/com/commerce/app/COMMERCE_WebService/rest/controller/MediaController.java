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

import com.commerce.app.COMMERCE_Business.events.Media.MediaEvent;
import com.commerce.app.COMMERCE_Business.events.Media.DeleteMediaEvent;
import com.commerce.app.COMMERCE_Business.events.Media.MediaAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Media.MediaDeletedEvent;
import com.commerce.app.COMMERCE_Business.services.MediaService;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryMedia;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@Api(value = "MediaRestController", description = "REST API for Media. To handle adding/deleting media for inventory")
@RestController
@RequestMapping("/api/action/media")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class MediaController {

	private static Logger LOG = LoggerFactory.getLogger(MediaController.class);
	
	@Autowired
	private MediaService mediaService;

	  @ApiOperation(value = "Adds an Inventory Media", tags = "addInventoryMedia")
		@ApiResponses(value = { 
		            @ApiResponse(code = 201, message = "Created"),
		            @ApiResponse(code = 401, message = "Not authorized"), 
		            @ApiResponse(code = 403, message = "Forbidden")
		          })
	@RequestMapping(value="/addMedia",method = RequestMethod.PUT)
	public ResponseEntity<InventoryMedia> addMedia (@RequestParam("data")@RequestBody InventoryMedia inventoryMedia , UriComponentsBuilder builder,
			@RequestParam(value="file", required=false) MultipartFile file) {
		if (!file.isEmpty()) {
            try {
            	 File convFile = new File( file.getOriginalFilename());
           	  	 file.transferTo(convFile);
           	  	 inventoryMedia.setMediaFile(convFile);
            } catch (Exception e) {
            	
            }
        } 
		
		MediaAddedEvent mediaAddedEvent =mediaService.addMedia(new MediaEvent(inventoryMedia.toMediaDetails()));
		InventoryMedia newInventoryMedia = inventoryMedia.fromMediaDetails(mediaAddedEvent.getMediaDetails());
		
		return new ResponseEntity<InventoryMedia>(newInventoryMedia,HttpStatus.CREATED);
	}
	
	  @ApiOperation(value = "Deletes an Inventory Media", tags = "deleteInventoryMedia")
		@ApiResponses(value = { 
		            @ApiResponse(code = 200, message = "Success|OK"),
		            @ApiResponse(code = 401, message = "Not authorized"), 
		            @ApiResponse(code = 403, message = "Forbidden"),
		            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/deleteMedia",method = RequestMethod.DELETE)
	public ResponseEntity<InventoryMedia> deleteMedia (@RequestBody InventoryMedia inventoryMedia, UriComponentsBuilder builder) {
		MediaDeletedEvent mediaDeletedEvent = mediaService.deleteMedia(new DeleteMediaEvent(inventoryMedia.toMediaDetails()));
		InventoryMedia newInventoryMedia = inventoryMedia.fromMediaDetails(mediaDeletedEvent.getMediaDetails());
		
		return new ResponseEntity<InventoryMedia>(newInventoryMedia,HttpStatus.OK);
	}
}
