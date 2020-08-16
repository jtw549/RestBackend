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

import com.commerce.app.COMMERCE_Business.services.SocialAccountService;
import com.commerce.app.COMMERCE_WebService.rest.domain.SocialAccounts;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "SocialMediaRestController", description = "REST API for handling social media connecting to user account")
@RestController
@RequestMapping("/aggregators/orders")
public class SocialAccountController {
	
	private static Logger LOG = LoggerFactory.getLogger(SocialAccountController.class);

	@Autowired
	private SocialAccountService socialAccountService;
	
	  @ApiOperation(value = "Updates SocialAccounts", response = SocialAccounts.class, tags = "updateSocialAccounts")
		@ApiResponses(value = { 
		            @ApiResponse(code = 200, message = "Success|OK"),
		            @ApiResponse(code = 401, message = "Not authorized"), 
		            @ApiResponse(code = 403, message = "Forbidden"),
		            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/updateSocialAccount",method = RequestMethod.POST)
	public ResponseEntity<SocialAccounts> updateSocialAccount(@RequestBody SocialAccounts socialAccounts, UriComponentsBuilder builder) {
		
		
		return null;
		
	}
	
	  @ApiOperation(value = "Updates SocialAccounts and return updated SocialAccounts", response = SocialAccounts.class, tags = "updateSocialAccounts")
		@ApiResponses(value = { 
		            @ApiResponse(code = 200, message = "Success|OK"),
		            @ApiResponse(code = 401, message = "Not authorized"), 
		            @ApiResponse(code = 403, message = "Forbidden"),
		            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/getSocialAccount",method = RequestMethod.GET)
	public ResponseEntity<SocialAccounts> getSocialAccount(@RequestBody SocialAccounts socialAccounts, UriComponentsBuilder builder) {
		
		
		return null;
		
	}
}
