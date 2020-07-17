package com.sthuf.app.STHUF_Domain.domain;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users2 {
	
	@Id
	private int userId;
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String password;
	
	private boolean userSocialAccounts;
	
	private String userPrivacy;
	
	private String email;
	
	private String userBio;
	
	private String profilePicUrl;
	
	private ArrayList<Inventories> usersInventories;
	
	private ArrayList<Messages> usersMessages;
	
	private ArrayList<UserCategories> usersCategories;
	
	private ArrayList<Friends> usersFriends;

	
	public ArrayList<Inventories> getUsersInventories() {
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
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isUserSocialAccounts() {
		return userSocialAccounts;
	}

	public void setUserSocialAccounts(boolean userSocialAccounts) {
		this.userSocialAccounts = userSocialAccounts;
	}

	public String getUserPrivacy() {
		return userPrivacy;
	}

	public void setUserPrivacy(String userPrivacy) {
		this.userPrivacy = userPrivacy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserBio() {
		return userBio;
	}

	public void setUserBio(String userBio) {
		this.userBio = userBio;
	}

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}
	
	
}
