package com.commerce.app.COMMERCE_Domain.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserCategoryArray {

	@Id
	private int userCategoriesId;
	
	private String categoryName;
	
	private String dateAdded;
	
	private int associatedCategoryId;

	public int getUserCategoriesId() {
		return userCategoriesId;
	}

	public void setUserCategoriesId(int userCategoriesId) {
		this.userCategoriesId = userCategoriesId;
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

	public int getAssociatedCategoryId() {
		return associatedCategoryId;
	}

	public void setAssociatedCategoryId(int associatedCategoryId) {
		this.associatedCategoryId = associatedCategoryId;
	}
	
	
}
