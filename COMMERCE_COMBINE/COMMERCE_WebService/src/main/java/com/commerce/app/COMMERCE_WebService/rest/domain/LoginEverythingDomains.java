package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Users.LoginEverythingDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonAutoDetect
public class LoginEverythingDomains implements Serializable{

	@JsonProperty(value="users")
	private com.commerce.app.COMMERCE_Domain.domain.Users2 users2;
	
	
	//@JsonProperty(value="items")
	//private ArrayList<com.commerce.app.COMMERCE_Domain.domain.Inventories> usersInventories;
	
	//private ArrayList<com.commerce.app.SCOMMERCE_Domain.domain.Messages> usersMessages;
	
	//@JsonProperty(value="UserCategory")
	//private UserCategories usersCategories;
	
	//private ArrayList<com.commerce.app.COMMERCE_Domain.domain.Friends> usersFriends;
	
	@JsonProperty(value="categories")
	private ArrayList<com.commerce.app.COMMERCE_Domain.domain.Categories> Categories;
	
	
	public com.commerce.app.COMMERCE_Domain.domain.Users2 getUsers() {
		return users2;
	}

	public void setUsers(com.commerce.app.COMMERCE_Domain.domain.Users2 users2) {
		this.users2 = users2;
	}


	/*public ArrayList<com.commerce.app.COMMERCE_Domain.domain.Inventories> getUsersInventories() {
		return usersInventories;
	}

	public void setUsersInventories(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.Inventories> usersInventories) {
		this.usersInventories = usersInventories;
	}

	public UserCategories getUsersCategories() {
		return usersCategories;
	}

	public void setUsersCategories(
			UserCategories usersCategories) {
		this.usersCategories = usersCategories;
	}*/

	public ArrayList<com.commerce.app.COMMERCE_Domain.domain.Categories> getCategories() {
		return Categories;
	}

	public void setCategories(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.Categories> categories) {
		Categories = categories;
	}

	public LoginEverythingDomains fromLoginEverythingDetails(LoginEverythingDetails loginEverythingDetails) {
		LoginEverythingDomains loginEverythingDomains = new LoginEverythingDomains();
		loginEverythingDomains.users2=loginEverythingDetails.getUsers();
		//loginEverythingDomains.usersCategories=loginEverythingDetails.getUsersCategories();
		//loginEverythingDomains.usersFriends=loginEverythingDetails.getUsersFriends();
		//loginEverythingDomains.usersInventories=loginEverythingDetails.getUsersInventories();
		//loginEverythingDomains.usersMessages=loginEverythingDetails.getUsersMessages();
		loginEverythingDomains.Categories=loginEverythingDetails.getCategories();
		return loginEverythingDomains;
		
	}
}
