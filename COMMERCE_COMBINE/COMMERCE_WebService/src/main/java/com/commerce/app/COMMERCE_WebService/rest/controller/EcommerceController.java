package com.commerce.app.COMMERCE_WebService.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.commerce.app.COMMERCE_Business.events.AppAuth.AppAuthenticatedEvent;
import com.commerce.app.COMMERCE_Business.events.AppAuth.AuthenticateAppEvent;
import com.commerce.app.COMMERCE_Business.services.AppAuthenticationService;
import com.commerce.app.COMMERCE_Business.services.EcommerceService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Ecommerces;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryNotes;

@Controller
@RequestMapping("/aggregators/orders")
public class EcommerceController {

	private static Logger LOG = LoggerFactory.getLogger(EcommerceController.class);
	
	@Autowired
	private EcommerceService ecommerceService;
	@Autowired
    private AppAuthenticationService appAuthenticationService;
	
	@RequestMapping(value="/sellItem",method = RequestMethod.POST)
	public ResponseEntity<Ecommerces> sellItem(@RequestBody Ecommerces ecommerces, UriComponentsBuilder builder) {
		AppAuthenticatedEvent appAuthenticatedEvent =appAuthenticationService.authenticateApp(new AuthenticateAppEvent(ecommerces.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Ecommerces>(ecommerces, HttpStatus.FORBIDDEN);
    	}
		
		return null;
		
	}
	
	@RequestMapping(value="/buyItem",method = RequestMethod.POST)
	public ResponseEntity<Ecommerces> buyItem(@RequestBody Ecommerces ecommerces, UriComponentsBuilder builder) {
		AppAuthenticatedEvent appAuthenticatedEvent =appAuthenticationService.authenticateApp(new AuthenticateAppEvent(ecommerces.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Ecommerces>(ecommerces, HttpStatus.FORBIDDEN);
    	}
		
		return null;
		
	}
}
