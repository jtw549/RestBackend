package com.commerce.app.COMMERCE_Business.events.Category;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.CreateEvent;
import com.commerce.app.COMMERCE_Domain.domain.UserCategories;
import com.commerce.app.COMMERCE_Domain.domain.UserCategoryArray;

public class CategoryAddedEvent extends CreateEvent{

/*	"status": "success",
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
	
	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}

	public CategoryAddedEvent(ArrayList<UserCategoryArray> userCategories ) {
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.toCategoryDetails(userCategories,categoryDetails);
		this.categoryDetails = categoryDetails;
	}
	
	public CategoryAddedEvent(UserCategories userCategories ) {
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.toCategoryDetails(userCategories,categoryDetails);
		this.categoryDetails = categoryDetails;
	}
}
