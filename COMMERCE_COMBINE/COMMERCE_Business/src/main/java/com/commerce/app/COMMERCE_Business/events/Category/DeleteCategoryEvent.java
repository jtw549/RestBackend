package com.commerce.app.COMMERCE_Business.events.Category;

import com.commerce.app.COMMERCE_Business.events.DeleteEvent;

public class DeleteCategoryEvent extends DeleteEvent{
/*	"category": {
    "userId": "3489EAGFOJG489UPGAJREP",
    "categoryId": "32KJDSFK4JWLSE4LKJRIFC"
}*/
	
	private CategoryDetails categoryDetails;

	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}
	
	public DeleteCategoryEvent (CategoryDetails categoryDetails) {
		this.categoryDetails = categoryDetails;
	}
}
