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

import com.commerce.app.COMMERCE_Business.services.EcommerceService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Ecommerces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "EcommerceRestController", description = "REST API for handling ecommerce tasks like buying and selling")
@RestController
@RequestMapping("/aggregators/orders")
public class EcommerceController {

	private static Logger LOG = LoggerFactory.getLogger(EcommerceController.class);
	
	@Autowired
	private EcommerceService ecommerceService;

	@ApiOperation(value = "Sell an item", response = Ecommerces.class, tags = "sellItem")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden")
	             })
	@RequestMapping(value="/sellItem",method = RequestMethod.PUT)
	public ResponseEntity<Ecommerces> sellItem(@RequestBody Ecommerces ecommerces, UriComponentsBuilder builder) {
		
		return null;
		
	}
	@ApiOperation(value = "Buy an item", response = Ecommerces.class, tags = "buyItem")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden")
	             })
	@RequestMapping(value="/buyItem",method = RequestMethod.PUT)
	public ResponseEntity<Ecommerces> buyItem(@RequestBody Ecommerces ecommerces, UriComponentsBuilder builder) {
		
		return null;
		
	}
	
	@ApiOperation(value = "Updates a User Item that was sold or bought", response = Ecommerces.class, tags = "updateItem")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden")
	             })
	@RequestMapping(value="/updateItem",method = RequestMethod.POST)
	public ResponseEntity<Ecommerces> updateItem(@RequestBody Ecommerces ecommerces, UriComponentsBuilder builder) {
		
		return null;
		
	}
}
