package com.sthuf.app.STHUF_Business.events.Category;

import com.sthuf.app.STHUF_Business.events.CreateEvent;

public class AddCategoryEvent extends CreateEvent {
/*	"category": {
    "userId": "3489EAGFOJG489UPGAJREP",
    "name": "Sports"
}*/
	private CategoryDetails categoryDetails;

	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}
	
	public AddCategoryEvent (CategoryDetails categoryDetails) {
		this.categoryDetails = categoryDetails;
	}
}
