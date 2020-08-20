package com.commerce.app.COMMERCE_Business.events.Category;

public class AddCategoryEvent  {
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
	
	/*public CategoryAddedEvent(ArrayList<UserCategoryArray> userCategories ) {
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.toCategoryDetails(userCategories,categoryDetails);
		this.categoryDetails = categoryDetails;
	}
	
	public CategoryAddedEvent(UserCategories userCategories ) {
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.toCategoryDetails(userCategories,categoryDetails);
		this.categoryDetails = categoryDetails;
	}
	
	public CategoryDeletedEvent(boolean deleted) {
		CategoryDetails categoryDetails = new CategoryDetails();
		this.categoryDetails = categoryDetails;
		this.setDeletionCompleted(deleted);
	}
	*/
}
