package com.commerce.app.COMMERCE_Business.events.Category;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.DeletedEvent;
import com.commerce.app.COMMERCE_Domain.domain.UserCategories;
import com.commerce.app.COMMERCE_Domain.domain.UserCategoryArray;

public class CategoryDeletedEvent extends DeletedEvent {
/*	 "status": "",
	    "message": "",
	    "categories": {
	        "count": "100",
	        "data": [
	            {
	                "categoryId": "",
	                "name": "Sporting Goods"
	            },
	            ...
	        ]
	    }*/
	
	private final CategoryDetails categoryDetails;
	
	private boolean deletionCompleted;
	
	public void setDeletionCompleted(boolean deletionCompleted) {
		this.deletionCompleted = deletionCompleted;
	}

	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}

	public CategoryDeletedEvent(boolean deleted) {
		CategoryDetails categoryDetails = new CategoryDetails();
		this.categoryDetails = categoryDetails;
		this.setDeletionCompleted(deleted);
	}
	
	public CategoryDeletedEvent(ArrayList<UserCategoryArray> userCategories) {
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.toCategoryDetails(userCategories,categoryDetails);
		this.categoryDetails = categoryDetails;
	}
	
	 public boolean isDeletionCompleted() {
		    return deletionCompleted;
		  }
}
