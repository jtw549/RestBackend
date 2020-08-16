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

import com.commerce.app.COMMERCE_Business.services.FriendsService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Friends;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "FriendRestController", description = "REST API for handling friends of user")
@RestController
@RequestMapping("/api/action/friends")
public class FriendController {

	private static Logger LOG = LoggerFactory.getLogger(FriendController.class);
	
	@Autowired
	private FriendsService friendsService;
	
	@ApiOperation(value = "Adds a friend for the user", tags = "addFriends")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized") 
	             })
	@RequestMapping(value="/addFriend",method = RequestMethod.PUT)
	public ResponseEntity<Friends> addFriend(@RequestBody Friends friends, UriComponentsBuilder builder) {
		return null;
		
	}
	@ApiOperation(value = "Deletes a friend for user",  tags = "deleteFriend")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized")
	             })
	@RequestMapping(value="/deleteFriend",method = RequestMethod.DELETE)
	public ResponseEntity<Friends> deleteFriend(@RequestBody Friends friends, UriComponentsBuilder builder) {
		
		return null;
		
	}
	@ApiOperation(value = "Gets a list of friends for user", response = Friends.class, tags = "getFriends")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized")
	         })
	@RequestMapping(value="/getFriends",method = RequestMethod.GET)
	public ResponseEntity<Friends> getFriends(@RequestBody Friends friends, UriComponentsBuilder builder) {
		
		return null;
		
	}
}
