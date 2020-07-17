package com.commerce.app.COMMERCE_Business.events.Users;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.*;


public class LoginEverythingDetails {
//add convert methods and add Arraylists for the webservice side
	private Users2 users2;

	private int position;
	
	/*private ArrayList<Inventories> usersInventories;
	
	private ArrayList<Messages> usersMessages;
	
	private ArrayList<UserCategories> usersCategories;
	
	private ArrayList<Friends> usersFriends;*/
	
	private ArrayList<Categories> Categories;
	
	public ArrayList<Categories> getCategories() {
		return Categories;
	}

	public void setCategories(ArrayList<Categories> categories) {
		Categories = categories;
	}

	public Users2 getUsers() {
		return users2;
	}

	public void setUsers(Users2 users2) {
		this.users2 = users2;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	/*public ArrayList<Inventories> getUsersInventories() {
		return usersInventories;
	}

	public void setUsersInventories(ArrayList<Inventories> usersInventories) {
		this.usersInventories = usersInventories;
	}

	public ArrayList<Messages> getUsersMessages() {
		return usersMessages;
	}

	public void setUsersMessages(ArrayList<Messages> usersMessages) {
		this.usersMessages = usersMessages;
	}

	public ArrayList<UserCategories> getUsersCategories() {
		return usersCategories;
	}

	public void setUsersCategories(ArrayList<UserCategories> usersCategories) {
		this.usersCategories = usersCategories;
	}

	public ArrayList<Friends> getUsersFriends() {
		return usersFriends;
	}

	public void setUsersFriends(ArrayList<Friends> usersFriends) {
		this.usersFriends = usersFriends;
	}*/
	
	public LoginEverythingDetails toLoginEverythingDetails(LoginEverythingDomain loginEverythingDomain,LoginEverythingDetails loginEverythingDomains) {
		loginEverythingDomains.setUsers(loginEverythingDomain.getUsers());
		loginEverythingDomains.setCategories(loginEverythingDomain.getCategories());
		/*loginEverythingDomains.setUsersFriends(loginEverythingDomain.getUsersFriends());
		loginEverythingDomains.setUsersInventories(loginEverythingDomain.getUsersInventories());
		loginEverythingDomains.setUsersMessages(loginEverythingDomain.getUsersMessages());
		loginEverythingDomains.setUsersCategories(loginEverythingDomain.getUsersCategories());*/
		return loginEverythingDomains;
		
	}
	
}
