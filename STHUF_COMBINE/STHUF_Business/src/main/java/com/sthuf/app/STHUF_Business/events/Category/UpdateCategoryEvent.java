package com.sthuf.app.STHUF_Business.events.Category;

import com.sthuf.app.STHUF_Business.events.UpdateEvent;

public class UpdateCategoryEvent extends UpdateEvent{
/*	"category": {
    "userId": "3489EAGFOJG489UPGAJREP",
    "categoryId": "32KJDSFK4JWLSE4LKJRIFC",
    "name": "Sporting Goods"
}*/
	private CategoryDetails categoryDetails;

	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}
	
	public UpdateCategoryEvent (CategoryDetails categoryDetails) {
		this.categoryDetails = categoryDetails;
	}
}
