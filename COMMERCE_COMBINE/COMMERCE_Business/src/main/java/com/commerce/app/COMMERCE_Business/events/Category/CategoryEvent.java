package com.commerce.app.COMMERCE_Business.events.Category;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.UserCategories;
import com.commerce.app.COMMERCE_Domain.domain.UserCategoryArray;

public class CategoryEvent  {
/*	"category": {
    "userId": "3489EAGFOJG489UPGAJREP",
    "name": "Sports"
}*/
	private CategoryDetails categoryDetails;

	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}
	
	public CategoryEvent (CategoryDetails categoryDetails) {
		this.categoryDetails = categoryDetails;
	}
	
	public CategoryEvent(ArrayList<UserCategoryArray> userCategories ) {
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.toCategoryDetails(userCategories,categoryDetails);
		this.categoryDetails = categoryDetails;
	}
	
	public CategoryEvent(UserCategories userCategories ) {
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.toCategoryDetails(userCategories,categoryDetails);
		this.categoryDetails = categoryDetails;
	}
	
	/*public CategoryDeletedEvent(boolean deleted) {
		CategoryDetails categoryDetails = new CategoryDetails();
		this.categoryDetails = categoryDetails;
		this.setDeletionCompleted(deleted);
	}*/
	
}
