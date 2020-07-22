package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Users.UserDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonAutoDetect
public class Users implements Serializable{

	@JsonProperty(value="position")
	private int position;
	
	@JsonProperty(value="formula")
	private String formula;
	
	@JsonProperty(value="userId")
	private int userId;
	
	@JsonProperty(value="firstName")
	private String firstName;
	
	@JsonProperty(value="lastName")
	private String lastName;
	
	@JsonProperty(value="userName")
	private String userName;
	
	@JsonProperty(value="metaPsd")
	private char[] password;
	
	@JsonProperty(value="userSocialAccounts")
	private boolean userSocialAccounts;
	
	@JsonProperty(value="userPrivacy")
	private String userPrivacy;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="userBio")
	private String userBio;
	
	@JsonProperty(value="profilePicUrl")
	private String profilePicUrl;
	
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
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

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
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

	public UserDetails toUserDetails() {
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(firstName);
		userDetails.setUserId(userId);
		userDetails.setLastName(lastName);
		userDetails.setUserPrivacy(userPrivacy);
		userDetails.setUserName(userName);
		userDetails.setPassword(password);
		userDetails.setUserSocialAccounts(userSocialAccounts);
		userDetails.setEmail(email);
		userDetails.setUserBio(userBio);
		userDetails.setProfilePicUrl(profilePicUrl);
		return userDetails;
	}
	
	public Users fromUserDetails(UserDetails userDetails) {
		Users users = new Users();
		users.firstName = userDetails.getFirstName();
		users.lastName = userDetails.getLastName();
		users.userPrivacy = userDetails.getUserPrivacy();
		users.userId = userDetails.getUserId();
		users.userSocialAccounts = userDetails.getUserSocialAccounts();
		users.email = userDetails.getEmail();
		users.userBio = userDetails.getUserBio();
		users.profilePicUrl = userDetails.getProfilePicUrl();
		users.password= userDetails.getPassword();
		users.userName=userDetails.getUserName();
		return users;
	}
	
	public ArrayList<String> appVerify(){
		ArrayList<String> appValues = new ArrayList<String>();
		appValues.add(formula);
		appValues.add(String.valueOf(position));
		return appValues;
		
	}
	
}
