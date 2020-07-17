package com.commerce.app.COMMERCE_Business.events.Category;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;

public class GetCategoryEvent extends ReadEvent{
/*	"category": {
    "userId": "3489EAGFOJG489UPGAJREP"
}*/
	private CategoryDetails categoryDetails;

	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}
	
	public GetCategoryEvent (CategoryDetails categoryDetails) {
		this.categoryDetails = categoryDetails;
	}
}
