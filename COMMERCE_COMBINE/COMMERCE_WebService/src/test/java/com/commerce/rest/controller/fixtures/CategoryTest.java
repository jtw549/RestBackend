package com.commerce.rest.controller.fixtures;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.commerce.app.COMMERCE_Business.shared.PropertyManager;
import com.commerce.app.COMMERCE_WebService.rest.domain.UserCategories;

public class CategoryTest {


	PropertyManager prop;
	HttpHeaders headers;
	RestTemplate template;
	
	@Before
	public void setUp() throws Exception {
		prop = PropertyManager.getInstance();
		prop.setConfigPropertiesPath("/COMMERCE_WebService/src/test/java/resources/test.properties");
		headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    template = new RestTemplate();
	}
	
	 @Test
	  public void catAdd() { 
	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    		 /*   HttpEntity<Users> requestEntity = new HttpEntity<Users>(
	    		createUser(),headers);*/

	    UserCategories entity = template.postForObject(
	      prop.getProperty("host.url")+ "/api/action/categories/addCategory",
	        requestEntity, UserCategories.class);
	    
	    //String path = entity.getHeaders().getLocation().getPath();

	    //assertEquals(HttpStatus.CREATED, entity.getStatusCode());
	    //assertTrue(path.startsWith("/api/action/users"));
	    //Users order = entity.getBody();

	    
	  }
	 
	 @Ignore
	 @Test
	  public void catdelete() {
	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    		 /*   HttpEntity<Users> requestEntity = new HttpEntity<Users>(
	    		createUser(),headers);*/
	    UserCategories entity = template.postForObject(
	    		 prop.getProperty("host.url")+ "/api/action/categories/deleteCategory",
	        requestEntity, UserCategories.class);

	    
	    
	    //String path = entity.getHeaders().getLocation().getPath();

	    //assertEquals(HttpStatus.CREATED, entity.getStatusCode());
	    //assertTrue(path.startsWith("/api/action/users"));
	    //Users order = entity.getBody();

	    
	  }
	 
	 @Ignore
	 @Test
	  public void catupdate() { 
	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    		 /*   HttpEntity<Users> requestEntity = new HttpEntity<Users>(
	    		createUser(),headers);*/

	    UserCategories entity = template.postForObject(
	    		 prop.getProperty("host.url")+ "/api/action/categories/updateCategory",
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
