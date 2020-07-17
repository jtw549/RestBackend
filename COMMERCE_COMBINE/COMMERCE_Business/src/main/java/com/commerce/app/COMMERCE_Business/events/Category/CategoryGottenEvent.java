package com.commerce.app.COMMERCE_Business.events.Category;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;
import com.commerce.app.COMMERCE_Domain.domain.UserCategories;
import com.commerce.app.COMMERCE_Domain.domain.UserCategoryArray;

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
