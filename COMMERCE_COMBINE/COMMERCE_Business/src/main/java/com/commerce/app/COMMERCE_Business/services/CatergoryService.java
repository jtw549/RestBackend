package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Category.CategoryEvent;


public interface CatergoryService {

	public CategoryEvent addCategory(CategoryEvent addCategoryEvent);
	public CategoryEvent deleteCategory(CategoryEvent deleteCategoryEvent);
	public CategoryEvent getCategory(CategoryEvent getCategoryEvent);
	public CategoryEvent updateCategory(CategoryEvent updateCategoryEvent);
	
	
}
