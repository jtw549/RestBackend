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

import com.commerce.app.COMMERCE_Business.events.Notes.AddNotesEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.DeleteNotesEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.GetNotesEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.NotesAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.NotesDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.NotesGottenEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.NotesUpdatedEvent;
import com.commerce.app.COMMERCE_Business.events.Notes.UpdateNotesEvent;
import com.commerce.app.COMMERCE_Business.services.NotesService;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryNotes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "NotesRestController", description = "REST API for handling of notes for inventory items")
@RestController
@RequestMapping("/api/action/notes")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class NotesController {
	
	private static Logger LOG = LoggerFactory.getLogger(NotesController.class);

	@Autowired
	private NotesService notesService;
	
	@ApiOperation(value = "Adding notes for inventory", tags = "addInventoryNotes")
	@ApiResponses(value = { 
			            @ApiResponse(code = 200, message = "Success|OK"),
			            @ApiResponse(code = 401, message = "Not authorized"), 
			            @ApiResponse(code = 403, message = "Forbidden")
			           })
	@RequestMapping(value="/addNote",method = RequestMethod.PUT)
	public ResponseEntity<InventoryNotes> addNote(@RequestBody InventoryNotes inventoryNotes, UriComponentsBuilder builder) {
		NotesAddedEvent notesAddedEvent = notesService.addNotes(new AddNotesEvent(inventoryNotes.toNotesDetails()));
    	InventoryNotes addInventoryNotes = inventoryNotes.fromNotesDetails(notesAddedEvent.getNotesDetails());
		
    	return new ResponseEntity<InventoryNotes>(addInventoryNotes, HttpStatus.CREATED);
		
	}
	
	  @ApiOperation(value = "Deletes an Inventory Note", tags = "deleteInventoryNotes")
			@ApiResponses(value = { 
			            @ApiResponse(code = 200, message = "Success|OK"),
			            @ApiResponse(code = 401, message = "Not authorized"), 
			            @ApiResponse(code = 403, message = "Forbidden"),
			            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/deleteNote",method = RequestMethod.DELETE)
	public ResponseEntity<InventoryNotes> deleteNote(@RequestBody InventoryNotes inventoryNotes, UriComponentsBuilder builder) {
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
	
	  @ApiOperation(value = "Gets Inventory Notes", response = InventoryNotes.class, tags = "getInventoryNotes")
			@ApiResponses(value = { 
			            @ApiResponse(code = 200, message = "Success|OK"),
			            @ApiResponse(code = 401, message = "Not authorized"), 
			            @ApiResponse(code = 403, message = "Forbidden"),
			            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/getNotes",method = RequestMethod.GET)
	public ResponseEntity<InventoryNotes> getNotes(@RequestBody InventoryNotes inventoryNotes, UriComponentsBuilder builder) {
    	NotesGottenEvent notesGottenEvent = notesService.getNotes(new GetNotesEvent(inventoryNotes.toNotesDetails()));
		InventoryNotes gottenInventoryNotes = inventoryNotes.fromNotesDetails(notesGottenEvent.getNotesDetails());
		return new ResponseEntity<InventoryNotes>(gottenInventoryNotes, HttpStatus.OK);
		
	}
	
	  @ApiOperation(value = "Updates Inventory Notes and return updated Inventory Notes", response = InventoryNotes.class, tags = "updateInventoryNotes")
			@ApiResponses(value = { 
			            @ApiResponse(code = 200, message = "Success|OK"),
			            @ApiResponse(code = 401, message = "Not authorized"), 
			            @ApiResponse(code = 403, message = "Forbidden"),
			            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/updateNote",method = RequestMethod.POST)
	public ResponseEntity<InventoryNotes> updateNote(@RequestBody InventoryNotes inventoryNotes, UriComponentsBuilder builder) {
    	NotesUpdatedEvent notesUpdatedEvent = notesService.updateNotes(new UpdateNotesEvent(inventoryNotes.toNotesDetails()));
		InventoryNotes updatedInventoryNotes = inventoryNotes.fromNotesDetails(notesUpdatedEvent.getNotesDetails());
		
		return new ResponseEntity<InventoryNotes>(updatedInventoryNotes, HttpStatus.OK);
		
	}
}
