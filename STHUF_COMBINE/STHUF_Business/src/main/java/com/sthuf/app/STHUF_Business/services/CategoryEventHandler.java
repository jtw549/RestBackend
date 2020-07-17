package com.sthuf.app.STHUF_Business.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;
import com.sthuf.app.STHUF_Business.events.Category.AddCategoryEvent;
import com.sthuf.app.STHUF_Business.events.Category.CategoryAddedEvent;
import com.sthuf.app.STHUF_Business.events.Category.CategoryDeletedEvent;
import com.sthuf.app.STHUF_Business.events.Category.CategoryGottenEvent;
import com.sthuf.app.STHUF_Business.events.Category.CategoryUpdatedEvent;
import com.sthuf.app.STHUF_Business.events.Category.DeleteCategoryEvent;
import com.sthuf.app.STHUF_Business.events.Category.GetCategoryEvent;
import com.sthuf.app.STHUF_Business.events.Category.UpdateCategoryEvent;
import com.sthuf.app.STHUF_Domain.domain.Inventories;
import com.sthuf.app.STHUF_Domain.domain.UserCategories;
import com.sthuf.app.STHUF_Domain.domain.UserCategoryArray;
import com.sthuf.app.STHUF_Domain.repository.CategoryRepository;


@Service("categoryService")
@ComponentScan("com.sthuf.app.STHUF_Domain.repository")
public class CategoryEventHandler implements CatergoryService{

	private static Logger LOG = LoggerFactory.getLogger(CategoryEventHandler.class);
	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	Query searchUserCategoryQuery;
	
	@Override
	public CategoryAddedEvent addCategory(AddCategoryEvent addCategoryEvent) {
		UserCategories userCategories = addCategoryEvent.getCategoryDetails().fromCategoryDetails();
		UserCategories userCategoriesResponse = categoryRepository.addUserCat(userCategories);
		return new CategoryAddedEvent(userCategoriesResponse);
	}
	
	@Override
	public CategoryDeletedEvent deleteCategory(DeleteCategoryEvent deleteCategoryEvent) {
		UserCategories userCategories = deleteCategoryEvent.getCategoryDetails().fromCategoryDetails();
		boolean isDeleted = categoryRepository.deleteUserCat(userCategories);
		
		return new CategoryDeletedEvent(isDeleted);
	}
	
	@Override
	public CategoryGottenEvent getCategory(GetCategoryEvent getCategoryEvent) {
		UserCategories userCategories = getCategoryEvent.getCategoryDetails().fromCategoryDetails();
		searchUserCategoryQuery
		= new Query(Criteria.where("userId").is(userCategories.getUserId()));
		UserCategories userCatArray = (UserCategories) mongoTemplate.find(searchUserCategoryQuery, UserCategories.class);
		
		return new CategoryGottenEvent(userCatArray);
	}
	
	@Override
	public CategoryUpdatedEvent updateCategory(UpdateCategoryEvent updateCategoryEvent) {
		UserCategories newUserCategories = updateCategoryEvent.getCategoryDetails().fromCategoryDetails();
		UserCategories userCategoriesResponse = categoryRepository.updateUserCat(newUserCategories);
		if(userCategoriesResponse == null) {
			LOG.error("User Category does not exist for update");
		}
		return new CategoryUpdatedEvent(userCategoriesResponse);
	}
}
