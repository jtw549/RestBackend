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

import com.commerce.app.COMMERCE_Business.events.Category.AddCategoryEvent;
import com.commerce.app.COMMERCE_Business.events.Category.CategoryAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Category.CategoryDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Category.CategoryGottenEvent;
import com.commerce.app.COMMERCE_Business.events.Category.CategoryUpdatedEvent;
import com.commerce.app.COMMERCE_Business.events.Category.DeleteCategoryEvent;
import com.commerce.app.COMMERCE_Business.events.Category.GetCategoryEvent;
import com.commerce.app.COMMERCE_Business.events.Category.UpdateCategoryEvent;
import com.commerce.app.COMMERCE_Business.services.CatergoryService;
import com.commerce.app.COMMERCE_WebService.rest.domain.UserCategories;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "CategoryRestController", description = "REST API for handling categories for inventory")
@RestController
@RequestMapping("/api/action/categories")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class CategoryController {
	
	private static Logger LOG = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CatergoryService catergoryService;
	
	@ApiOperation(value = "Adds a User Categories", response = UserCategories.class, tags = "addCategory")
	@ApiResponses(value = { 
	            @ApiResponse(code = 201, message = "Created"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden") })
	@RequestMapping(value="/addCategory",method = RequestMethod.PUT)
	public ResponseEntity<UserCategories> addCategories(@RequestBody UserCategories categories, UriComponentsBuilder builder) {
		
    	CategoryAddedEvent categoryAddedEvent = catergoryService.addCategory(new AddCategoryEvent(categories.toCategoryDetails()));
		UserCategories newUserCategories = categories.fromCategoryDetails(categoryAddedEvent.getCategoryDetails());
    	
		return new ResponseEntity<UserCategories>(newUserCategories, HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value = "Updates a User Categories", response = UserCategories.class, tags = "updateCategory")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden")
	             })
	@RequestMapping(value="/updateCategory",method = RequestMethod.POST)
	public ResponseEntity<UserCategories> updateCategories(@RequestBody UserCategories categories, UriComponentsBuilder builder) {
		CategoryUpdatedEvent categoryUpdatedEvent = catergoryService.updateCategory(new UpdateCategoryEvent(categories.toCategoryDetails()));
    	UserCategories updatedUserCategories = categories.fromCategoryDetails(categoryUpdatedEvent.getCategoryDetails());
    	
    	return new ResponseEntity<UserCategories>(updatedUserCategories, HttpStatus.OK);
		
	}
	@ApiOperation(value = "Deletes a User Categories", response = UserCategories.class, tags = "deleteCategory")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/deleteCategory",method = RequestMethod.DELETE)
	public ResponseEntity<UserCategories> deleteCategories(@RequestBody UserCategories categories, UriComponentsBuilder builder) {
    	CategoryDeletedEvent categoryDeletedEvent = catergoryService.deleteCategory(new DeleteCategoryEvent(categories.toCategoryDetails()));
    	UserCategories deletedUserCategories = categories.fromCategoryDetails(categoryDeletedEvent.getCategoryDetails());
		
    	if (!categoryDeletedEvent.isEntityFound()) {
            return new ResponseEntity<UserCategories>(HttpStatus.NOT_FOUND);
        }
        if (categoryDeletedEvent.isDeletionCompleted()) {
            return new ResponseEntity<UserCategories>(deletedUserCategories, HttpStatus.OK);
        }
        
    	return new ResponseEntity<UserCategories>(deletedUserCategories, HttpStatus.FORBIDDEN);
		
	}
	@ApiOperation(value = "Gets User Categories", response = UserCategories.class, tags = "getCategory")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Not authorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value="/getCategories",method = RequestMethod.GET)
	public ResponseEntity<UserCategories> getCategories(@RequestBody UserCategories categories, UriComponentsBuilder builder) {
    	CategoryGottenEvent categoryGottenEvent = catergoryService.getCategory(new GetCategoryEvent(categories.toCategoryDetails()));
    	UserCategories gottenUserCategories = categories.fromCategoryDetails(categoryGottenEvent.getCategoryDetails());
    	
    	return new ResponseEntity<UserCategories>(gottenUserCategories, HttpStatus.OK);
		
	}
}
