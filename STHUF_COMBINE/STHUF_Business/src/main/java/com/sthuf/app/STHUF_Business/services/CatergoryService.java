package com.sthuf.app.STHUF_Business.services;

import com.sthuf.app.STHUF_Business.events.Category.AddCategoryEvent;
import com.sthuf.app.STHUF_Business.events.Category.CategoryAddedEvent;
import com.sthuf.app.STHUF_Business.events.Category.CategoryDeletedEvent;
import com.sthuf.app.STHUF_Business.events.Category.CategoryGottenEvent;
import com.sthuf.app.STHUF_Business.events.Category.CategoryUpdatedEvent;
import com.sthuf.app.STHUF_Business.events.Category.DeleteCategoryEvent;
import com.sthuf.app.STHUF_Business.events.Category.GetCategoryEvent;
import com.sthuf.app.STHUF_Business.events.Category.UpdateCategoryEvent;


public interface CatergoryService {

	public CategoryAddedEvent addCategory(AddCategoryEvent addCategoryEvent);
	public CategoryDeletedEvent deleteCategory(DeleteCategoryEvent deleteCategoryEvent);
	public CategoryGottenEvent getCategory(GetCategoryEvent getCategoryEvent);
	public CategoryUpdatedEvent updateCategory(UpdateCategoryEvent updateCategoryEvent);
	
	
}
