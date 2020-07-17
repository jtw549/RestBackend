package com.sthuf.rest.controller.fixtures;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.sthuf.app.STHUF_WebService.rest.domain.UserCategories;

public class CategoryTest {

	
	 @Test
	  public void catAdd() { 
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    		 /*   HttpEntity<Users> requestEntity = new HttpEntity<Users>(
	    		createUser(),headers);*/

	    UserCategories entity = template.postForObject(
	        "http://localhost:8081/STHUF_WebService-3.0-SNAPSHOT/api/action/categories/addCategory",
	        requestEntity, UserCategories.class);

	    
	    
	    //String path = entity.getHeaders().getLocation().getPath();

	    //assertEquals(HttpStatus.CREATED, entity.getStatusCode());
	    //assertTrue(path.startsWith("/api/action/users"));
	    //Users order = entity.getBody();

	    
	  }
	 
	 @Ignore
	 @Test
	  public void catdelete() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    		 /*   HttpEntity<Users> requestEntity = new HttpEntity<Users>(
	    		createUser(),headers);*/
	    UserCategories entity = template.postForObject(
	        "http://localhost:8081/STHUF_WebService-3.0-SNAPSHOT/api/action/categories/deleteCategory",
	        requestEntity, UserCategories.class);

	    
	    
	    //String path = entity.getHeaders().getLocation().getPath();

	    //assertEquals(HttpStatus.CREATED, entity.getStatusCode());
	    //assertTrue(path.startsWith("/api/action/users"));
	    //Users order = entity.getBody();

	    
	  }
	 
	 @Ignore
	 @Test
	  public void catupdate() { 
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    		 /*   HttpEntity<Users> requestEntity = new HttpEntity<Users>(
	    		createUser(),headers);*/

	    UserCategories entity = template.postForObject(
	        "http://localhost:8081/STHUF_WebService-3.0-SNAPSHOT/api/action/categories/updateCategory",
	        requestEntity, UserCategories.class);

	    
	    
	    //String path = entity.getHeaders().getLocation().getPath();

	    //assertEquals(HttpStatus.CREATED, entity.getStatusCode());
	    //assertTrue(path.startsWith("/api/action/users"));
	    //Users order = entity.getBody();

	    
	  }
	 
	 public static String standardOrderJSON() {
			 
		 return "{\"userId\": 5, \"categoryName\": \"spamyou1\", \"associatedCategoryId\": 7}";
	 }
	 
}
