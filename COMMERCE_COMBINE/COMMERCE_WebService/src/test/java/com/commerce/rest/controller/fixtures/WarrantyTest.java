package com.commerce.rest.controller.fixtures;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.commerce.app.COMMERCE_Business.shared.PropertyManager;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryWarranty;

public class WarrantyTest {

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
	  public void warrantyAdd() {

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryWarranty entity = template.postForObject(
	    		prop.getProperty("host.url")+  "/api/action/warranties/addWarranty",
	        requestEntity, InventoryWarranty.class);

	  }
	 
	 @Test 
	  public void warrantyDelete() {
	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryWarranty entity = template.postForObject(
	    		prop.getProperty("host.url")+ "/api/action/warranties/deleteWarranty",
	        requestEntity, InventoryWarranty.class);

	  }
	 
	 @Test 
	  public void warrantyUpdate() {

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryWarranty entity = template.postForObject(
	    		prop.getProperty("host.url")+ "/api/action/warranties/updateWarranty",
	        requestEntity, InventoryWarranty.class);

	  }
	 
	 public static String standardOrderJSON() { 
		 
			 return "{\"userId\": 1 ,\"inventoryId\": 1}";
		 }
}
