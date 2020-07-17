package com.sthuf.app.STHUF_Business.events.Category;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.ReadEvent;
import com.sthuf.app.STHUF_Domain.domain.UserCategories;
import com.sthuf.app.STHUF_Domain.domain.UserCategoryArray;

public class CategoryGottenEvent extends ReadEvent{
/*	"categories": {
    "count": 100,
    "data": [
        {
            "categoryId": "",
            "name": "Sports",
            "dateAdded": ""
        },
         {
            "categoryId": "",
            "name": "Sneakers",
            "dateAdded": ""
        },
        ...
    ]
}*/
	private final CategoryDetails categoryDetails;
	
	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}

	public CategoryGottenEvent(UserCategories userCategories) {
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.toCategoryDetails(userCategories,categoryDetails);
		this.categoryDetails = categoryDetails;
	}
}
