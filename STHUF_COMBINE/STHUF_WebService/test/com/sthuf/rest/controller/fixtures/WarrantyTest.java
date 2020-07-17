package com.sthuf.rest.controller.fixtures;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.sthuf.app.STHUF_WebService.rest.domain.InventoryWarranty;

public class WarrantyTest {

	 @Test 
	  public void warrantyAdd() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryWarranty entity = template.postForObject(
	        "http://localhost:8081/STHUF_WebService-3.0-SNAPSHOT/api/action/warranties/addWarranty",
	        requestEntity, InventoryWarranty.class);

	  }
	 
	 @Test 
	  public void warrantyDelete() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryWarranty entity = template.postForObject(
	        "http://localhost:8081/STHUF_WebService-3.0-SNAPSHOT/api/action/warranties/deleteWarranty",
	        requestEntity, InventoryWarranty.class);

	  }
	 
	 @Test 
	  public void warrantyUpdate() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryWarranty entity = template.postForObject(
	        "http://localhost:8081/STHUF_WebService-3.0-SNAPSHOT/api/action/warranties/updateWarranty",
	        requestEntity, InventoryWarranty.class);

	  }
	 
	 public static String standardOrderJSON() { 
		 
			 return "{\"userId\": 1 ,\"inventoryId\": 1}";
		 }
}
