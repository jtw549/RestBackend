package com.commerce.rest.controller.fixtures;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.commerce.app.COMMERCE_Business.shared.PropertyManager;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryComments;

public class CommentsTest {


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
	  public void commentsAdd() {
	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryComments entity = template.postForObject(
	    		prop.getProperty("host.url")+ "/api/action/comments/addComment",
	        requestEntity, InventoryComments.class);

	  }
	 
	 @Test 
	  public void commentsDelete() {
	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryComments entity = template.postForObject(
	    		prop.getProperty("host.url")+ "/api/action/comments/deleteComment",
	        requestEntity, InventoryComments.class);

	  }
	 
	 @Test 
	  public void commentsUpdate() {
	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryComments entity = template.postForObject(
	    		prop.getProperty("host.url")+ "/api/action/comments/updateComment",
	        requestEntity, InventoryComments.class);

	  }
	 public static String standardOrderJSON() { 
		 
			 return "{\"userId\": 1 ,\"inventoryId\": 1}";
		 }
}
