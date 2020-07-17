package com.sthuf.rest.controller.fixtures;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.sthuf.app.STHUF_WebService.rest.domain.Inventories;

public class ItemsTest {
	
	 @Ignore
	 @Test 
	  public void itemAdd() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    Inventories entity = template.postForObject(
	        "http://localhost:8081/STHUF_WebService-3.0-SNAPSHOT/api/action/items/addItem",
	        requestEntity, Inventories.class);

	  }
	 
	 @Test 
	  public void itemdelete() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    Inventories entity = template.postForObject(
	        "http://localhost:8081/STHUF_WebService-3.0-SNAPSHOT/api/action/items/deleteItem",
	        requestEntity, Inventories.class);

	  }
	 
	 @Ignore
	 @Test 
	  public void itemupdate() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    Inventories entity = template.postForObject(
	        "http://localhost:8081/STHUF_WebService-3.0-SNAPSHOT/api/action/items/updateItem",
	        requestEntity, Inventories.class);

	  }
	
	 public static String standardOrderJSON() { 
		 
			/* return "{\"position\": 2, \"formula\": \"asdad\",\"userId\": 1 ,\"inventoryId\": 1," +
			 		" \"categoryId\": 3, \"userCategoryId\": 5, \"make\": \"American\"," +
			 		" \"name\": \"morceeba\", \"serialNumber\": \"hh34asd833\", \"seller\": \"urmomswarehouse\", " +
			 		" \"price\": \"$5.99\", \"purchaseDate\": \"11-12-2014\", \"model\": \"omega model\", " +
			 		" \"quantity\": 500, \"conditions\": [], \"likes\": 1, " +
			 		" \"privacy\": \"true\", \"shareLink\": \"www.kickit.com\", \"shareEmbed\": \"asskicked.com\", " +
			 		" \"inventoryComments\": [], \"inventoryNotes\": [], " +
			 		" \"inventoryTags\": [], \"inventoryMedias\": [], \"updatedDate\": \"11-12-2014\", " +
			 		"\"createdDate\": \"11-12-2014\"}";*/
			 
			 return "{\"userId\": 1 ,\"inventoryId\": 1}";
		 }
}
