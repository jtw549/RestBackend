package com.commerce.app.COMMERCE_Business.events.Users;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.SocialAccount.SocialAccountDetails;
import com.commerce.app.COMMERCE_Domain.domain.SocialAccounts;
import com.commerce.app.COMMERCE_Domain.domain.Users;

public class UserDetails {

	private int userId;
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String password;
	
	private boolean hasUserSocialAccounts;
	
	private String userPrivacy;
	
	private String email;
	
	private String userBio;
	
	private String profilePicUrl;
	
	public boolean isHasUserSocialAccounts() {
		return hasUserSocialAccounts;
	}

	public void setHasUserSocialAccounts(boolean hasUserSocialAccounts) {
		this.hasUserSocialAccounts = hasUserSocialAccounts;
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

	public boolean getUserSocialAccounts() {
		return hasUserSocialAccounts;
	}

	public void setUserSocialAccounts(boolean userSocialAccounts) {
		this.hasUserSocialAccounts = userSocialAccounts;
	}

	public String getUserPrivacy() {
		return userPrivacy;
	}

	public void setUserPrivacy(String userPrivacy) {
		this.userPrivacy = userPrivacy;
	}
	

	public UserDetails toUserDetails(Users users,UserDetails userDetails) {
		userDetails.setFirstName(users.getFirstName());
		userDetails.setUserId(users.getUserId());
		userDetails.setLastName(users.getLastName());
		userDetails.setUserPrivacy(users.getUserPrivacy());
		userDetails.setUserName(users.getUserName());
		userDetails.setPassword(users.getPassword());
		userDetails.setUserSocialAccounts(users.isUserSocialAccounts());
		userDetails.setEmail(users.getEmail());
		userDetails.setUserBio(users.getUserBio());
		userDetails.setProfilePicUrl(users.getProfilePicUrl());
		return userDetails;
	}
	
	public Users fromUserDetails() {
		Users users = new Users();
		users.setFirstName(firstName);
		users.setLastName(lastName);
		users.setUserPrivacy(userPrivacy);
		users.setUserId(userId);
		users.setUserSocialAccounts(hasUserSocialAccounts);
		users.setEmail(email);
		users.setUserBio(userBio);
		users.setPassword(password);
		users.setUserName(userName);
		users.setProfilePicUrl(profilePicUrl);
		return users;
	}

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}
	
}
