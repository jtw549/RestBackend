package com.sthuf.app.STHUF_Domain.domain;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserCategories")
public class UserCategories {
	
	@Id
	private int incrementedUserCatNum;
	
	private int userId;
	
	private String categoryName;
	
	private String dateAdded;
	
	private int associatedCategoryId;
	
	private ArrayList<UserCategoryArray> userCategoryArray;
	
	public UserCategories() {
		
	}

	public int getAssociatedCategoryId() {
		return associatedCategoryId;
	}

	public void setAssociatedCategoryId(int associatedCategoryId) {
		this.associatedCategoryId = associatedCategoryId;
	}

	public ArrayList<UserCategoryArray> getUserCategoryArray() {
		return userCategoryArray;
	}

	public void setUserCategoryArray(ArrayList<UserCategoryArray> userCategoryArray) {
		this.userCategoryArray = userCategoryArray;
	}

	public int getUserCategoriesId() {
		return incrementedUserCatNum;
	}

	public void setUserCategoriesId(int userCategoriesId) {
		this.incrementedUserCatNum = userCategoriesId;
	}

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

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getAssociatedCategory() {
		return associatedCategoryId;
	}

	public void setAssociatedCategory(int associatedCategory) {
		this.associatedCategoryId = associatedCategory;
	}
}
