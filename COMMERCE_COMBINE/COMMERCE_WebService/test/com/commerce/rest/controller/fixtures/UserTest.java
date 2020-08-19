package com.commerce.rest.controller.fixtures;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.commerce.app.COMMERCE_WebService.rest.domain.Users;

public class UserTest {

	 @Test 
	  public void userRegister() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(
	    		standardOrderJSON(),headers);
	    
	    		 /*   HttpEntity<Users> requestEntity = new HttpEntity<Users>(
	    		createUser(),headers);*/

	    Users entity = template.postForObject(
	        "http://localhost:8081/COMMERCE_WebService-3.0-SNAPSHOT/api/action/users/registerUser",
	        requestEntity, Users.class);

	    
	    
	    //String path = entity.getHeaders().getLocation().getPath();

	    //assertEquals(HttpStatus.CREATED, entity.getStatusCode());
	    //assertTrue(path.startsWith("/api/action/users"));
	    //Users order = entity.getBody();

	    
	  }
	 @Ignore
	 @Test 
	  public void userLogin() {
		 	HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		    RestTemplate template = new RestTemplate();

		    HttpEntity<String> requestEntity = new HttpEntity<String>(
		    		standardOrderJSON(),headers);
		    
		    		 /*   HttpEntity<Users> requestEntity = new HttpEntity<Users>(
		    		createUser(),headers);*/

		    Users entity = template.postForObject(
		        "http://localhost:8081/COMMERCE_WebService-3.0-SNAPSHOT/api/action/users/login",
		        requestEntity, Users.class);

		    
		    
		    //String path = entity.getHeaders().getLocation().getPath();

		    //assertEquals(HttpStatus.CREATED, entity.getStatusCode());
		    //assertTrue(path.startsWith("/api/action/users"));
		    //Users order = entity.getBody();

	 }
	 
	 public static String standardOrderJSON() {
			 
		// return "{\"position\": 2, \"formula\": \"asdad\",\"firstName\": \"joeee\", \"lastName\": \"will\", \"userName\": \"America\", \"password\": \"pass\", \"userSocialAccounts\": true, \"userPrivacy\": \"yes\", \"email\": \"asdssada.com\", \"userBio\": \"bio\",  \"profilePicUrl\": \"adsda\"}";
		 return "{\"position\": 2, \"formula\": \"asdad\",\"userId\": 1 ,\"firstName\": \"brandon\", \"lastName\": \"mordas\", \"userName\": \"bmord\", \"metaPsd\": \"pass2\", \"userSocialAccounts\": true, \"userPrivacy\": \"yes\", \"email\": \"omega@sada.com\", \"userBio\": \"bio222\",  \"profilePicUrl\": \"adffa\"}";
		 //return "{\"metaPsd\": \"sasdasd\", \"email\": \"sadas@yahoo.com\"}";
	 }
	 
}
