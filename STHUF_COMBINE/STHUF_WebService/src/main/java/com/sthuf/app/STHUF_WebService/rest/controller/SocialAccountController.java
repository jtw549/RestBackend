package com.sthuf.app.STHUF_WebService.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.sthuf.app.STHUF_Business.services.AppAuthenticationService;
import com.sthuf.app.STHUF_Business.services.SocialAccountService;
import com.sthuf.app.STHUF_WebService.rest.domain.SocialAccounts;

@Controller
@RequestMapping("/aggregators/orders")
public class SocialAccountController {
	
	private static Logger LOG = LoggerFactory.getLogger(SocialAccountController.class);

	@Autowired
	private SocialAccountService socialAccountService;
	@Autowired
    private AppAuthenticationService appAuthenticationService;
	
	@RequestMapping(value="/updateSocialAccount",method = RequestMethod.PUT)
	public ResponseEntity<SocialAccounts> updateSocialAccount(@RequestBody SocialAccounts socialAccounts, UriComponentsBuilder builder) {
		
		
		return null;
		
	}
	

	@RequestMapping(value="/getSocialAccount",method = RequestMethod.GET)
	public ResponseEntity<SocialAccounts> getSocialAccount(@RequestBody SocialAccounts socialAccounts, UriComponentsBuilder builder) {
		
		
		return null;
		
	}
}
