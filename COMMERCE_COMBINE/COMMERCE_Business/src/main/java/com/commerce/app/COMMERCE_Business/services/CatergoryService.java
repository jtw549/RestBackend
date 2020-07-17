package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Category.AddCategoryEvent;
import com.commerce.app.COMMERCE_Business.events.Category.CategoryAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Category.CategoryDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Category.CategoryGottenEvent;
import com.commerce.app.COMMERCE_Business.events.Category.CategoryUpdatedEvent;
import com.commerce.app.COMMERCE_Business.events.Category.DeleteCategoryEvent;
import com.commerce.app.COMMERCE_Business.events.Category.GetCategoryEvent;
import com.commerce.app.COMMERCE_Business.events.Category.UpdateCategoryEvent;


public interface CatergoryService {

	public CategoryAddedEvent addCategory(AddCategoryEvent addCategoryEvent);
	public CategoryDeletedEvent deleteCategory(DeleteCategoryEvent deleteCategoryEvent);
	public CategoryGottenEvent getCategory(GetCategoryEvent getCategoryEvent);
	public CategoryUpdatedEvent updateCategory(UpdateCategoryEvent updateCategoryEvent);
	
	
}
