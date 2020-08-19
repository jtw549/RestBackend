package com.commerce.rest.controller.fixtures;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryComments;

public class CommentsTest {

	 @Test 
	  public void commentsAdd() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryComments entity = template.postForObject(
	        "http://localhost:8081/COMMERCE_WebService-3.0-SNAPSHOT/api/action/comments/addComment",
	        requestEntity, InventoryComments.class);

	  }
	 
	 @Test 
	  public void commentsDelete() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryComments entity = template.postForObject(
	        "http://localhost:8081/COMMERCE_WebService-3.0-SNAPSHOT/api/action/comments/deleteComment",
	        requestEntity, InventoryComments.class);

	  }
	 
	 @Test 
	  public void commentsUpdate() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryComments entity = template.postForObject(
	        "http://localhost:8081/COMMERCE_WebService-3.0-SNAPSHOT/api/action/comments/updateComment",
	        requestEntity, InventoryComments.class);

	  }
	 public static String standardOrderJSON() { 
		 
			 return "{\"userId\": 1 ,\"inventoryId\": 1}";
		 }
}
