package com.commerce.rest.controller.fixtures;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryNotes;

public class NotesTest {

	 
	 @Test 
	  public void notesAdd() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryNotes entity = template.postForObject(
	        "http://localhost:8081/COMMERCE_WebService-3.0-SNAPSHOT/api/action/notes/addNote",
	        requestEntity, InventoryNotes.class);

	  }
	 
	 @Test 
	  public void notesDelete() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryNotes entity = template.postForObject(
	        "http://localhost:8081/COMMERCE_WebService-3.0-SNAPSHOT/api/action/notes/deleteNote",
	        requestEntity, InventoryNotes.class);

	  }
	 
	 @Test 
	  public void notesUpdate() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryNotes entity = template.postForObject(
	        "http://localhost:8081/COMMERCE_WebService-3.0-SNAPSHOT/api/action/notes/updateNote",
	        requestEntity, InventoryNotes.class);

	  }
	 
	 public static String standardOrderJSON() { 
		 
			 return "{\"userId\": 1 ,\"inventoryId\": 1}";
		 }
}
