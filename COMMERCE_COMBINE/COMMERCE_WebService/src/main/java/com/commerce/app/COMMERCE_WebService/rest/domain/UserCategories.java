package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Required;

import com.commerce.app.COMMERCE_Business.events.Category.CategoryDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonAutoDetect
public class UserCategories implements Serializable{
	
	@JsonProperty(value="userId")
	private int userId;
	
	@JsonProperty(value="categoryName")
	private String categoryName;
	
	@JsonProperty(value="userCategoriesId")
	private int userCategoriesId;
	
	@JsonProperty(value="dateAdded")
	private String dateAdded;
	
	@JsonProperty(value="associatedCategoryId")
	private int associatedCategoryId;
	
	
	@JsonProperty(value="userCategoriesList")
	private ArrayList<com.commerce.app.COMMERCE_Domain.domain.UserCategoryArray> userCategoriesList;
	

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public int getUserCategoriesId() {
		return userCategoriesId;
	}

	public void setUserCategoriesId(int userCategoriesId) {
		this.userCategoriesId = userCategoriesId;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getAssociatedCategoryId() {
		return associatedCategoryId;
	}

	public void setAssociatedCategoryId(int associatedCategoryId) {
		this.associatedCategoryId = associatedCategoryId;
	}

	public ArrayList<com.commerce.app.COMMERCE_Domain.domain.UserCategoryArray> getUserCategoriesList() {
		return userCategoriesList;
	}

	public void setUserCategoriesList(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.UserCategoryArray> userCategoriesList) {
		this.userCategoriesList = userCategoriesList;
	}

	public CategoryDetails toCategoryDetails() {
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.setCategoryName(categoryName);
		categoryDetails.setAssociatedCategory(associatedCategoryId);
		categoryDetails.setDateAdded(dateAdded);
		categoryDetails.setUserCategoriesId(userCategoriesId);
		categoryDetails.setUserId(userId);
		return categoryDetails;
		
	}
	
	public UserCategories fromCategoryDetails(CategoryDetails categoryDetails) {
		UserCategories userCategories = new UserCategories();
		userCategories.categoryName = categoryDetails.getCategoryName();
		userCategories.associatedCategoryId = categoryDetails.getAssociatedCategory();
		userCategories.dateAdded = categoryDetails.getDateAdded();
		userCategories.userCategoriesId = categoryDetails.getUserCategoriesId();
		userCategories.userId =  categoryDetails.getUserId();
		userCategories.userCategoriesList = categoryDetails.getCategories();
		return userCategories;
		
	}
	
}
