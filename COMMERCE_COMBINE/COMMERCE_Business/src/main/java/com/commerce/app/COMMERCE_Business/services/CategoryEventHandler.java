package com.commerce.app.COMMERCE_Business.services;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.Category.CategoryEvent;
import com.commerce.app.COMMERCE_Domain.domain.UserCategories;
import com.commerce.app.COMMERCE_Domain.repository.CategoryRepository;

@Aspect
@EnableAspectJAutoProxy
@Service("categoryService")
@ComponentScan("com.commerce.app.COMMERCE_Domain.repository")
public class CategoryEventHandler implements CatergoryService{

	private static Logger LOG = LoggerFactory.getLogger(CategoryEventHandler.class);
	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	Query searchUserCategoryQuery;

	
	@Override
	public CategoryEvent addCategory(CategoryEvent addCategoryEvent) {
		UserCategories userCategories = addCategoryEvent.getCategoryDetails().fromCategoryDetails();
		UserCategories userCategoriesResponse = categoryRepository.addUserCat(userCategories);
		return new CategoryEvent(userCategoriesResponse);
	}
	
	@Override
	public CategoryEvent deleteCategory(CategoryEvent deleteCategoryEvent) {
		UserCategories userCategories = deleteCategoryEvent.getCategoryDetails().fromCategoryDetails();
		boolean isDeleted = categoryRepository.deleteUserCat(userCategories);
		//return boolean
		return new CategoryEvent(isDeleted);
	}
	
	@Override
	public CategoryEvent getCategory(CategoryEvent getCategoryEvent) {
		UserCategories userCategories = getCategoryEvent.getCategoryDetails().fromCategoryDetails();
		searchUserCategoryQuery
		= new Query(Criteria.where("userId").is(userCategories.getUserId()));
		UserCategories userCatArray = (UserCategories) mongoTemplate.find(searchUserCategoryQuery, UserCategories.class);
		
		return new CategoryEvent(userCatArray);
	}
	
	@Override
	public CategoryEvent updateCategory(CategoryEvent updateCategoryEvent) {
		UserCategories newUserCategories = updateCategoryEvent.getCategoryDetails().fromCategoryDetails();
		UserCategories userCategoriesResponse = categoryRepository.updateUserCat(newUserCategories);
		if(userCategoriesResponse == null) {
			LOG.error("User Category does not exist for update");
		}
		return new CategoryEvent(userCategoriesResponse);
	}
}
