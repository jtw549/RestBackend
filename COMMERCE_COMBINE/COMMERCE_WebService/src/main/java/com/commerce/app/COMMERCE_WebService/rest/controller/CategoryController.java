package com.commerce.app.COMMERCE_WebService.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


@Controller
@RequestMapping("/api/action/categories")
@ComponentScan("com.commerce.app.COMMERCE_Business.services")
public class CategoryController {
	
	private static Logger LOG = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CatergoryService catergoryService;
	
/*	@Autowired
    private AppAuthenticationService appauthenticationService;*/
	
		@RequestMapping(value="/addCategory",method = RequestMethod.POST)
	public ResponseEntity<UserCategories> addCategories(@RequestBody UserCategories categories, UriComponentsBuilder builder) {
	/*	AppAuthenticatedEvent appAuthenticatedEvent = appauthenticationService.authenticateApp(new AuthenticateAppEvent(categories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<UserCategories>(categories, HttpStatus.FORBIDDEN);
    	}*/
		
    	CategoryAddedEvent categoryAddedEvent = catergoryService.addCategory(new AddCategoryEvent(categories.toCategoryDetails()));
		UserCategories newUserCategories = categories.fromCategoryDetails(categoryAddedEvent.getCategoryDetails());
    	
		return new ResponseEntity<UserCategories>(newUserCategories, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/updateCategory",method = RequestMethod.PUT)
	public ResponseEntity<UserCategories> updateCategories(@RequestBody UserCategories categories, UriComponentsBuilder builder) {
	/*	AppAuthenticatedEvent appAuthenticatedEvent = appauthenticationService.authenticateA.
		CategoryUpdatedEvent categoryUpdatedEvent = catergoryService.updateCategory(new UpdateCategoryEvent(categories.toCategoryDetails()));
    	UserCategories updatedUserCategories = categories.fromCategoryDetails(categoryUpdatedEvent.getCategoryDetails());
    	
    	return new ResponseEntity<UserCategories>(updatedUserCategories, HttpStatus.OK);*/
		
	}
	
	@RequestMapping(value="/deleteCategory",method = RequestMethod.DELETE)
	public ResponseEntity<UserCategories> deleteCategories(@RequestBody UserCategories categories, UriComponentsBuilder builder) {
		/*AppAuthenticatedEvent appAuthenticatedEvent = appauthenticationService.authenticateApp(new AuthenticateAppEvent(categories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<UserCategories>(categories, HttpStatus.FORBIDDEN);
    	}*/
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
	
	@RequestMapping(value="/getCategories",method = RequestMethod.GET)
	public ResponseEntity<UserCategories> getCategories(@RequestBody UserCategories categories, UriComponentsBuilder builder) {
	/*	AppAuthenticatedEvent appAuthenticatedEvent = appauthenticationService.authenticateApp(new AuthenticateAppEvent(categories.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<UserCategories>(categories, HttpStatus.FORBIDDEN);
    	}*/
    	CategoryGottenEvent categoryGottenEvent = catergoryService.getCategory(new GetCategoryEvent(categories.toCategoryDetails()));
    	UserCategories gottenUserCategories = categories.fromCategoryDetails(categoryGottenEvent.getCategoryDetails());
    	
    	return new ResponseEntity<UserCategories>(gottenUserCategories, HttpStatus.OK);
		
	}
}
