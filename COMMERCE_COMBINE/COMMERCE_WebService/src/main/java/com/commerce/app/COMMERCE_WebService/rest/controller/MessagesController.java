package com.commerce.app.COMMERCE_WebService.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.commerce.app.COMMERCE_Business.services.MessagesService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Messages;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "MessageRestController", description = "REST API for handling of messages between users")
@RestController
@RequestMapping("/api/action/messages")
public class MessagesController {
	
	private static Logger LOG = LoggerFactory.getLogger(MessagesController.class);
	@Autowired
	private MessagesService messagesService;
	
	//Ignore for now...
	 /* @ApiOperation(value = "Deletes an Inventory Note", tags = "deleteInventoryNotes")
		@ApiResponses(value = { 
		            @ApiResponse(code = 200, message = "Success|OK"),
		            @ApiResponse(code = 401, message = "Not authorized"), 
		            @ApiResponse(code = 403, message = "Forbidden"),
		            @ApiResponse(code = 404, message = "Not Found") })*/
	@RequestMapping(value="/sendMessage",method = RequestMethod.PUT)
	public ResponseEntity<Messages> sendMessage(@RequestBody Messages messages, UriComponentsBuilder builder) {
		
		return null;
		
	}
	 /* @ApiOperation(value = "Deletes an Inventory Note", tags = "deleteInventoryNotes")
		@ApiResponses(value = { 
		            @ApiResponse(code = 200, message = "Success|OK"),
		            @ApiResponse(code = 401, message = "Not authorized"), 
		            @ApiResponse(code = 403, message = "Forbidden"),
		            @ApiResponse(code = 404, message = "Not Found") })*/
	@RequestMapping(value="/getMessage",method = RequestMethod.GET)
	public ResponseEntity<Messages> getMessage(@RequestBody Messages messages, UriComponentsBuilder builder) {
		
		return null;
		
	}
	 /* @ApiOperation(value = "Deletes an Inventory Note", tags = "deleteInventoryNotes")
		@ApiResponses(value = { 
		            @ApiResponse(code = 200, message = "Success|OK"),
		            @ApiResponse(code = 401, message = "Not authorized"), 
		            @ApiResponse(code = 403, message = "Forbidden"),
		            @ApiResponse(code = 404, message = "Not Found") })*/
	@RequestMapping(value="/deleteConversation",method = RequestMethod.DELETE)
	public ResponseEntity<Messages> deleteConversation(@RequestBody Messages messages, UriComponentsBuilder builder) {
		
		return null;
		
	}
}
