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

import com.commerce.app.COMMERCE_Business.events.Comments.AddCommentsEvent;
import com.commerce.app.COMMERCE_Business.events.Comments.CommentsAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Comments.CommentsDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Comments.CommentsGottenEvent;
import com.commerce.app.COMMERCE_Business.events.Comments.CommentsUpdatedEvent;
import com.commerce.app.COMMERCE_Business.events.Comments.DeleteCommentsEvent;
import com.commerce.app.COMMERCE_Business.events.Comments.GetCommentsEvent;
import com.commerce.app.COMMERCE_Business.events.Comments.UpdateCommentsEvent;
import com.commerce.app.COMMERCE_Business.services.CommentsService;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryComments;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "CommentsRestController", description = "REST API for handling comments on inventory")
@RestController
@RequestMapping("/api/action/comments")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class CommentsController {
	
	private static Logger LOG = LoggerFactory.getLogger(CommentsController.class);

	@Autowired
	private CommentsService commentsService;

	@ApiOperation(value = "Adds a User Comment", response = InventoryComments.class, tags = "addComment")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden")
	             })
	@RequestMapping(value="/addComment",method = RequestMethod.PUT)
	public ResponseEntity<InventoryComments> addComment(@RequestBody InventoryComments inventoryComments, UriComponentsBuilder builder) {
		CommentsAddedEvent commentsAddedEvent = commentsService.addComments(new AddCommentsEvent(inventoryComments.toCommentsDetails()));
    	InventoryComments addedInventoryComments = inventoryComments.fromCommentsDetails(commentsAddedEvent.getCommentsDetails());
    	
    	return new ResponseEntity<InventoryComments>(addedInventoryComments, HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value = "Deletes a User Comment", tags = "deleteComment")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found")
	             })
	@RequestMapping(value="/deleteComment",method = RequestMethod.DELETE)
	public ResponseEntity<InventoryComments> deleteComment(@RequestBody InventoryComments inventoryComments, UriComponentsBuilder builder) {
    	CommentsDeletedEvent commentsDeletedEvent = commentsService.deleteComments(new DeleteCommentsEvent(inventoryComments.toCommentsDetails()));
		InventoryComments deletedInventoryComments = inventoryComments.fromCommentsDetails(commentsDeletedEvent.getCommentsDetails());
    	
		if (!commentsDeletedEvent.isEntityFound()) {
            return new ResponseEntity<InventoryComments>(HttpStatus.NOT_FOUND);
        }
        if (commentsDeletedEvent.isDeletionCompleted()) {
            return new ResponseEntity<InventoryComments>(deletedInventoryComments, HttpStatus.OK);
        }
        
		return new ResponseEntity<InventoryComments>(deletedInventoryComments, HttpStatus.FORBIDDEN);
		
	}
	
	@ApiOperation(value = "Get comments", response = InventoryComments.class, tags = "getComments")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized") 
	             })
	@RequestMapping(value="/getComments",method = RequestMethod.GET)
	public ResponseEntity<InventoryComments> getComments(@RequestBody InventoryComments inventoryComments, UriComponentsBuilder builder) {
    	CommentsGottenEvent commentsGottenEvent = commentsService.getComments(new GetCommentsEvent(inventoryComments.toCommentsDetails()));
		InventoryComments gottenInventoryComments = inventoryComments.fromCommentsDetails(commentsGottenEvent.getCommentsDetails());
    	
		return new ResponseEntity<InventoryComments>(gottenInventoryComments, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Updates a User comment", response = InventoryComments.class, tags = "updateComment")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden")
	             })
	@RequestMapping(value="/updateComment",method = RequestMethod.POST)
	public ResponseEntity<InventoryComments> updateComment(@RequestBody InventoryComments inventoryComments, UriComponentsBuilder builder) {
    	CommentsUpdatedEvent commentsUpdatedEvent = commentsService.updateComments(new UpdateCommentsEvent(inventoryComments.toCommentsDetails()));
    	InventoryComments updatedInventoryComments = inventoryComments.fromCommentsDetails(commentsUpdatedEvent.getCommentsDetails());
		
		return new ResponseEntity<InventoryComments>(updatedInventoryComments, HttpStatus.OK);
		
	}
	
}
