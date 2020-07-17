package com.sthuf.app.STHUF_Business.events.Category;

import com.sthuf.app.STHUF_Business.events.UpdatedEvent;
import com.sthuf.app.STHUF_Domain.domain.UserCategories;

public class CategoryUpdatedEvent extends UpdatedEvent{

	 /*"status": "",
	 "message": ""*/
	
	private final CategoryDetails categoryDetails;
	
	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}

	public CategoryUpdatedEvent(UserCategories userCategories) {
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.toCategoryDetails(userCategories,categoryDetails);
		this.categoryDetails = categoryDetails;
	}
}
