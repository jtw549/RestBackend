package com.sthuf.app.STHUF_WebService.rest.controller;

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

import com.sthuf.app.STHUF_Business.events.AppAuth.AppAuthenticatedEvent;
import com.sthuf.app.STHUF_Business.events.AppAuth.AuthenticateAppEvent;
import com.sthuf.app.STHUF_Business.events.Comments.AddCommentsEvent;
import com.sthuf.app.STHUF_Business.events.Comments.CommentsAddedEvent;
import com.sthuf.app.STHUF_Business.events.Comments.CommentsDeletedEvent;
import com.sthuf.app.STHUF_Business.events.Comments.CommentsGottenEvent;
import com.sthuf.app.STHUF_Business.events.Comments.CommentsUpdatedEvent;
import com.sthuf.app.STHUF_Business.events.Comments.DeleteCommentsEvent;
import com.sthuf.app.STHUF_Business.events.Comments.GetCommentsEvent;
import com.sthuf.app.STHUF_Business.events.Comments.UpdateCommentsEvent;
import com.sthuf.app.STHUF_Business.services.AppAuthenticationService;
import com.sthuf.app.STHUF_Business.services.CommentsService;
import com.sthuf.app.STHUF_WebService.rest.domain.Inventories;
import com.sthuf.app.STHUF_WebService.rest.domain.InventoryComments;

@Controller
@RequestMapping("/api/action/comments")
@ComponentScan("com.sthuf.app.STHUF_Business.services")
public class CommentsController {
	
	private static Logger LOG = LoggerFactory.getLogger(CommentsController.class);

	@Autowired
	private CommentsService commentsService;
	@Autowired
    private AppAuthenticationService appAuthenticationService;
	
	@RequestMapping(value="/addComment",method = RequestMethod.POST)
	public ResponseEntity<InventoryComments> addComment(@RequestBody InventoryComments inventoryComments, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryComments.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryComments>(inventoryComments, HttpStatus.FORBIDDEN);
    	}*/
		CommentsAddedEvent commentsAddedEvent = commentsService.addComments(new AddCommentsEvent(inventoryComments.toCommentsDetails()));
    	InventoryComments addedInventoryComments = inventoryComments.fromCommentsDetails(commentsAddedEvent.getCommentsDetails());
    	
    	return new ResponseEntity<InventoryComments>(addedInventoryComments, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/deleteComment",method = RequestMethod.POST)
	public ResponseEntity<InventoryComments> deleteComment(@RequestBody InventoryComments inventoryComments, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryComments.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryComments>(inventoryComments, HttpStatus.FORBIDDEN);
    	}*/
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
	
	@RequestMapping(value="/getComments",method = RequestMethod.POST)
	public ResponseEntity<InventoryComments> getComments(@RequestBody InventoryComments inventoryComments, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryComments.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryComments>(inventoryComments, HttpStatus.FORBIDDEN);
    	}*/
    	CommentsGottenEvent commentsGottenEvent = commentsService.getComments(new GetCommentsEvent(inventoryComments.toCommentsDetails()));
		InventoryComments gottenInventoryComments = inventoryComments.fromCommentsDetails(commentsGottenEvent.getCommentsDetails());
    	
		return new ResponseEntity<InventoryComments>(gottenInventoryComments, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/updateComment",method = RequestMethod.POST)
	public ResponseEntity<InventoryComments> updateComment(@RequestBody InventoryComments inventoryComments, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryComments.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryComments>(inventoryComments, HttpStatus.FORBIDDEN);
    	}*/
    	CommentsUpdatedEvent commentsUpdatedEvent = commentsService.updateComments(new UpdateCommentsEvent(inventoryComments.toCommentsDetails()));
    	InventoryComments updatedInventoryComments = inventoryComments.fromCommentsDetails(commentsUpdatedEvent.getCommentsDetails());
		
		return new ResponseEntity<InventoryComments>(updatedInventoryComments, HttpStatus.OK);
		
	}
	
}
