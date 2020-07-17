package com.sthuf.app.STHUF_WebService.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.sthuf.app.STHUF_Business.events.AppAuth.AppAuthenticatedEvent;
import com.sthuf.app.STHUF_Business.events.AppAuth.AuthenticateAppEvent;
import com.sthuf.app.STHUF_Business.events.Users.DeleteUserEvent;
import com.sthuf.app.STHUF_Business.events.Users.GetUserAccountInfoEvent;
import com.sthuf.app.STHUF_Business.events.Users.LoginUserEvent;
import com.sthuf.app.STHUF_Business.events.Users.RegisterUserEvent;
import com.sthuf.app.STHUF_Business.events.Users.UpdateUserEvent;
import com.sthuf.app.STHUF_Business.events.Users.UserAccountInfoGottenEvent;
import com.sthuf.app.STHUF_Business.events.Users.UserDeletedEvent;
import com.sthuf.app.STHUF_Business.events.Users.UserLoggedInEvent;
import com.sthuf.app.STHUF_Business.events.Users.UserRegisteredEvent;
import com.sthuf.app.STHUF_Business.events.Users.UserUpdatedEvent;
import com.sthuf.app.STHUF_Business.services.AppAuthenticationService;
import com.sthuf.app.STHUF_Business.services.UsersService;
import com.sthuf.app.STHUF_WebService.rest.domain.LoginEverythingDomains;
import com.sthuf.app.STHUF_WebService.rest.domain.Users;



@Controller
@RequestMapping("/api/action/users")
@ComponentScan("com.sthuf.app.STHUF_Business.services")
public class UsersController {

    private static Logger LOG = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService userService;
    
   /* @Autowired
    private AppAuthenticationService appAuthenticationService;*/
	
    @RequestMapping(value="/registerUser",method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<Users> registerUser(@RequestBody Users users) {
    	/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(users.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Users>(users, HttpStatus.FORBIDDEN);
    	}
    	*/
    	UserRegisteredEvent registerUserEvent = userService.registerUser(new RegisterUserEvent(users.toUserDetails()));
    	Users newUsers = users.fromUserDetails(registerUserEvent.getUserDetails());
		
		return new ResponseEntity<Users>(newUsers,HttpStatus.CREATED);
		
	}
    
    @RequestMapping(value="/updateUser",method = RequestMethod.PUT)
	public ResponseEntity<Users> updateUser(@RequestBody Users users) {
    	/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(users.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Users>(users, HttpStatus.FORBIDDEN);
    	}*/
    	
    	UserUpdatedEvent updateUserEvent = userService.updateUser(new UpdateUserEvent(users.toUserDetails()));
		Users updatedUsers = users.fromUserDetails(updateUserEvent.getUserDetails());
		
		return new ResponseEntity<Users>(updatedUsers,HttpStatus.OK);
		
	}
    
    @RequestMapping(value="/deleteUser",method = RequestMethod.DELETE)
	public ResponseEntity<Users> deleteUser(@RequestBody Users users) {
    	/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(users.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Users>(users, HttpStatus.FORBIDDEN);
    	}*/
    	
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
    
    @RequestMapping(value="/getAccountInfo",method = RequestMethod.GET)
	public ResponseEntity<Users> getAccountInfo(@RequestBody Users users) {
    	/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(users.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Users>(users, HttpStatus.FORBIDDEN);
    	}*/
    	
    	UserAccountInfoGottenEvent getUserAccountInfoEvent= userService.getAccountInfo(new GetUserAccountInfoEvent(users.toUserDetails()));
    	Users gotUsers = users.fromUserDetails(getUserAccountInfoEvent.getUserDetails());
		
    	return new ResponseEntity<Users>(gotUsers,HttpStatus.OK);
		
	}
    
    @RequestMapping(value="/login",method = RequestMethod.POST)
	public ResponseEntity<LoginEverythingDomains> loginUser(@RequestBody Users users) {
    	LoginEverythingDomains login = new LoginEverythingDomains();
    	/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(users.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<LoginEverythingDomains>(login, HttpStatus.FORBIDDEN);
    	}*/
    	
    	UserLoggedInEvent loginUserEvent = userService.loginUser(new LoginUserEvent(users.toUserDetails()));
    	LoginEverythingDomains loginEverythingDomains = login.fromLoginEverythingDetails(loginUserEvent.getUserDetails());
		
    	return new ResponseEntity<LoginEverythingDomains>(loginEverythingDomains,HttpStatus.OK);
		
	}
    
    @RequestMapping(value="/logout",method = RequestMethod.POST)
	public ResponseEntity<Users> logoutUser(@RequestBody Users users) {
		//how is this gonna work?
    	/*AppAuthenticatedEvent appAuthenticatedEvent = appAuthenticationService.authenticateApp(new AuthenticateAppEvent(users.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Users>(users, HttpStatus.FORBIDDEN);
    	}*/
		return new ResponseEntity<Users>(users,HttpStatus.OK);
		
	}
    
}
