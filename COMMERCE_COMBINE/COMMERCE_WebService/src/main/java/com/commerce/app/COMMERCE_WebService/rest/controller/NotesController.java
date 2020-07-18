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
import com.commerce.app.COMMERCE_Business.events.Notes.AddNotesEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.DeleteNotesEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.GetNotesEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.NotesAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.NotesDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.NotesGottenEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.NotesUpdatedEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.UpdateNotesEvent;
import com.commerce.app.COMMERCE_Business.services.AppAuthenticationService;
import com.commerce.app.COMMERCE_Business.services.NotesService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Inventories;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryNotes;

@Controller
@RequestMapping("/api/action/notes")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class NotesController {
	
	private static Logger LOG = LoggerFactory.getLogger(NotesController.class);

	@Autowired
	private NotesService notesService;
	@Autowired
    private AppAuthenticationService appAuthenticationService;
	
	@RequestMapping(value="/addNote",method = RequestMethod.POST)
	public ResponseEntity<InventoryNotes> addNote(@RequestBody InventoryNotes inventoryNotes, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryNotes.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryNotes>(inventoryNotes, HttpStatus.FORBIDDEN);
    	}*/
		NotesAddedEvent notesAddedEvent = notesService.addNotes(new AddNotesEvent(inventoryNotes.toNotesDetails()));
    	InventoryNotes addInventoryNotes = inventoryNotes.fromNotesDetails(notesAddedEvent.getNotesDetails());
		
    	return new ResponseEntity<InventoryNotes>(addInventoryNotes, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/deleteNote",method = RequestMethod.DELETE)
	public ResponseEntity<InventoryNotes> deleteNote(@RequestBody InventoryNotes inventoryNotes, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryNotes.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryNotes>(inventoryNotes, HttpStatus.FORBIDDEN);
    	}*/
    	
    	
    	NotesDeletedEvent notesDeletedEvent = notesService.deleteNotes(new DeleteNotesEvent(inventoryNotes.toNotesDetails()));
    	InventoryNotes deletedInventoryNotes = inventoryNotes.fromNotesDetails(notesDeletedEvent.getNotesDetails());
    	
    	if (!notesDeletedEvent.isEntityFound()) {
            return new ResponseEntity<InventoryNotes>(HttpStatus.NOT_FOUND);
        }
        if (notesDeletedEvent.isDeletionCompleted()) {
            return new ResponseEntity<InventoryNotes>(deletedInventoryNotes, HttpStatus.OK);
        }
        
		return new ResponseEntity<InventoryNotes>(deletedInventoryNotes, HttpStatus.FORBIDDEN);
		
	}
	
	@RequestMapping(value="/getNotes",method = RequestMethod.GET)
	public ResponseEntity<InventoryNotes> getNotes(@RequestBody InventoryNotes inventoryNotes, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryNotes.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryNotes>(inventoryNotes, HttpStatus.FORBIDDEN);
    	}*/
    	NotesGottenEvent notesGottenEvent = notesService.getNotes(new GetNotesEvent(inventoryNotes.toNotesDetails()));
		InventoryNotes gottenInventoryNotes = inventoryNotes.fromNotesDetails(notesGottenEvent.getNotesDetails());
		return new ResponseEntity<InventoryNotes>(gottenInventoryNotes, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/updateNote",method = RequestMethod.PUT)
	public ResponseEntity<InventoryNotes> updateNote(@RequestBody InventoryNotes inventoryNotes, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(inventoryNotes.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<InventoryNotes>(inventoryNotes, HttpStatus.FORBIDDEN);
    	}*/
    	NotesUpdatedEvent notesUpdatedEvent = notesService.updateNotes(new UpdateNotesEvent(inventoryNotes.toNotesDetails()));
		InventoryNotes updatedInventoryNotes = inventoryNotes.fromNotesDetails(notesUpdatedEvent.getNotesDetails());
		
		return new ResponseEntity<InventoryNotes>(updatedInventoryNotes, HttpStatus.OK);
		
	}
}
