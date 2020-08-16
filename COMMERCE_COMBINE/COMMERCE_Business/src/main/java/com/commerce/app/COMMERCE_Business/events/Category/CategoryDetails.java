package com.commerce.app.COMMERCE_Business.events.Category;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.UserCategories;
import com.commerce.app.COMMERCE_Domain.domain.UserCategoryArray;

public class CategoryDetails {
	
	private int userCategoriesId;
	
	private int userId;
	
	private String categoryName;
	
	private String dateAdded;
	
	private int associatedCategory;
	
	private ArrayList<UserCategoryArray> categories;

	public ArrayList<UserCategoryArray> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<UserCategoryArray> categories) {
		this.categories = categories;
	}

	public int getUserCategoriesId() {
		return userCategoriesId;
	}

	public void setUserCategoriesId(int userCategoriesId) {
		this.userCategoriesId = userCategoriesId;
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
		return associatedCategory;
	}

	public void setAssociatedCategory(int associatedCategory) {
		this.associatedCategory = associatedCategory;
	}

	public CategoryDetails toCategoryDetails(UserCategories userCategories,CategoryDetails categoryDetails) {
		categoryDetails.setCategoryName(userCategories.getCategoryName());
		categoryDetails.setAssociatedCategory(userCategories.getUserCategoriesId());
		categoryDetails.setDateAdded(userCategories.getDateAdded());
		categoryDetails.setUserCategoriesId(userCategories.getUserCategoriesId());
		categoryDetails.setUserId(userCategories.getUserId());
		categoryDetails.setCategories(userCategories.getUserCategoryArray());
		return categoryDetails;
		
	}
	
	public CategoryDetails toCategoryDetails(ArrayList<UserCategoryArray> userCategories,CategoryDetails categoryDetails) {
		categoryDetails.setCategories(userCategories);
				return categoryDetails;
	}
	
	public UserCategories fromCategoryDetails() {
		UserCategories userCategories = new UserCategories();
		userCategories.setCategoryName(categoryName);
		userCategories.setAssociatedCategory(associatedCategory);
		userCategories.setDateAdded(dateAdded);
		userCategories.setUserCategoriesId(userCategoriesId);
		userCategories.setUserId(userId);
		userCategories.setUserCategoryArray(categories);
		return userCategories;
		
	}
	
}
