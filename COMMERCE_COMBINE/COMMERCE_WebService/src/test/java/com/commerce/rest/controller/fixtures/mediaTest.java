package com.commerce.rest.controller.fixtures;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.commerce.app.COMMERCE_Business.shared.PropertyManager;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryMedia;

public class mediaTest {


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
	  public void mediaAdd() {
	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    InventoryMedia entity = template.postForObject(
	    		prop.getProperty("host.url")+ "/api/action/media/addMedia",
	        requestEntity, InventoryMedia.class);

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
