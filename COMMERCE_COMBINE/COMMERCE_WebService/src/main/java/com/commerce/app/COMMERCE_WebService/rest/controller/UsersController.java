package com.commerce.app.COMMERCE_WebService.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.app.COMMERCE_Business.events.Users.DeleteUserEvent;
import com.commerce.app.COMMERCE_Business.events.Users.GetUserAccountInfoEvent;
import com.commerce.app.COMMERCE_Business.events.Users.UserEvent;
import com.commerce.app.COMMERCE_Business.events.Users.RegisterUserEvent;
import com.commerce.app.COMMERCE_Business.events.Users.UpdateUserEvent;
import com.commerce.app.COMMERCE_Business.events.Users.UserAccountInfoGottenEvent;
import com.commerce.app.COMMERCE_Business.events.Users.UserDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Users.UserLoggedInEvent;
import com.commerce.app.COMMERCE_Business.events.Users.UserRegisteredEvent;
import com.commerce.app.COMMERCE_Business.events.Users.UserUpdatedEvent;
import com.commerce.app.COMMERCE_Business.services.UsersService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Users;
import com.commerce.app.COMMERCE_WebService.rest.domain.LoginEverythingDomains;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "UserRestController", description = "REST API for handling anything related to user")
@RestController
@RequestMapping("/api/action/users")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class UsersController {

    private static Logger LOG = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService userService;
    
    @ApiOperation(value = "Register User and return user", response = Users.class, tags = "registerUsers")
	@ApiResponses(value = { 
	            @ApiResponse(code = 201, message = "Created")
	           })
    @RequestMapping(value="/registerUser",method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<Users> registerUser(@RequestBody Users users) {
    	UserRegisteredEvent registerUserEvent = userService.registerUser(new RegisterUserEvent(users.toUserDetails()));
    	Users newUsers = users.fromUserDetails(registerUserEvent.getUserDetails());
		
		return new ResponseEntity<Users>(newUsers,HttpStatus.CREATED);
		
	}
    
    @ApiOperation(value = "Updates User and return updated user", response = Users.class, tags = "updateUsers")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value="/updateUser",method = RequestMethod.POST)
	public ResponseEntity<Users> updateUser(@RequestBody Users users) {
    	
    	UserUpdatedEvent updateUserEvent = userService.updateUser(new UpdateUserEvent(users.toUserDetails()));
		Users updatedUsers = users.fromUserDetails(updateUserEvent.getUserDetails());
		
		return new ResponseEntity<Users>(updatedUsers,HttpStatus.OK);
		
	}
    
    @ApiOperation(value = "Delete User", response = Users.class, tags = "deleteUsers")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden")
	             })
    @RequestMapping(value="/deleteUser",method = RequestMethod.DELETE)
	public ResponseEntity<Users> deleteUser(@RequestBody Users users) {
    	
    	UserDeletedEvent deleteUserEvent = userService.deleteUser(new DeleteUserEvent(users.toUserDetails()));
		Users deletedUsers = users.fromUserDetails(deleteUserEvent.getUserDetails());

        if (!deleteUserEvent.isEntityFound()) {
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
        if (deleteUserEvent.isDeletionCompleted()) {
            return new ResponseEntity<Users>(deletedUsers, HttpStatus.OK);
        }

        return new ResponseEntity<Users>(deletedUsers, HttpStatus.FORBIDDEN);
		
	}
    
    @ApiOperation(value = "Get User account information", response = Users.class, tags = "getAccountInfoUsers")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value="/getAccountInfo",method = RequestMethod.GET)
	public ResponseEntity<Users> getAccountInfo(@RequestBody Users users) {
    	
    	UserAccountInfoGottenEvent getUserAccountInfoEvent= userService.getAccountInfo(new GetUserAccountInfoEvent(users.toUserDetails()));
    	Users gotUsers = users.fromUserDetails(getUserAccountInfoEvent.getUserDetails());
		
    	return new ResponseEntity<Users>(gotUsers,HttpStatus.OK);
		
	}
    
    @ApiOperation(value = "Login User and return everything associated with the user", response = Users.class, tags = "loginUsers")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value="/login",method = RequestMethod.POST)
	public ResponseEntity<LoginEverythingDomains> loginUser(@RequestBody Users users) {
    	LoginEverythingDomains login = new LoginEverythingDomains();
    	
    	UserLoggedInEvent loginUserEvent = userService.loginUser(new UserEvent(users.toUserDetails()));
    	LoginEverythingDomains loginEverythingDomains = login.fromLoginEverythingDetails(loginUserEvent.getUserDetails());
		
    	return new ResponseEntity<LoginEverythingDomains>(loginEverythingDomains,HttpStatus.OK);
		
	}
    
    @ApiOperation(value = "Logout User", response = Users.class, tags = "logoutUsers")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value="/logout",method = RequestMethod.POST)
	public ResponseEntity<Users> logoutUser(@RequestBody Users users) {
		//how is this gonna work?
		return new ResponseEntity<Users>(users,HttpStatus.OK);
		
	}
    
}
