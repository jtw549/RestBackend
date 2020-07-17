package com.commerce.app.COMMERCE_Domain.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.neo4j.cypher.internal.compiler.v2_1.ast.rewriters.isolateAggregation;
import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.expression.spel.support.BooleanTypedValue;
import org.springframework.stereotype.Repository;

import com.commerce.app.COMMERCE_Domain.config.SpringMongoConfig1;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.UserCategories;
import com.commerce.app.COMMERCE_Domain.domain.UserCategoryArray;
import com.mongodb.WriteResult;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
	
	ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	Query searchUserCategoryQuery;
	
	public UserCategories addUserCat(UserCategories userCategories){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		searchUserCategoryQuery
		= new Query(Criteria.where("userId").is(userCategories.getUserId()));
		UserCategories userCategoriesgotten = 
				(UserCategories) mongoOperation.findOne(searchUserCategoryQuery,UserCategories.class);
		UserCategoryArray userCategoryArray = new UserCategoryArray();
		userCategoryArray.setAssociatedCategoryId(userCategories.getAssociatedCategoryId());
		userCategoryArray.setCategoryName(userCategories.getCategoryName());
		userCategoryArray.setDateAdded(dateFormat.format(date));
		userCategoryArray.setUserCategoriesId(userCategories.getUserId()+1);
		ArrayList<UserCategoryArray> userCategoryArrays = new ArrayList<UserCategoryArray>();
		if(userCategoriesgotten != null) {
			userCategoryArrays= userCategoriesgotten.getUserCategoryArray();
			int arraySize = userCategoryArrays.size();
			userCategoryArray.setUserCategoriesId(userCategoryArrays.get(arraySize-1).getUserCategoriesId()+1);
		}
		userCategoryArrays.add(userCategoryArray);
		userCategories.setUserCategoryArray(userCategoryArrays);
		userCategories.setUserId(userCategories.getUserId());
		userCategories.setCategoryName(null);
		userCategories.setAssociatedCategoryId(0);
		userCategories.setUserCategoriesId(0);
		mongoOperation.save(userCategories);
		searchUserCategoryQuery
		= new Query(Criteria.where("userId").is(userCategories.getUserId()));
		//needs to fix
		UserCategories userCategoriesResponse = 
				(UserCategories) mongoOperation.findOne(searchUserCategoryQuery,UserCategories.class);
		
		return userCategoriesResponse;
		
	}
	
	public boolean deleteUserCat(UserCategories userCategories) {
		boolean isDeleted = false;
		searchUserCategoryQuery
		= new Query(Criteria.where("userId").is(userCategories.getUserId()));
		UserCategories uCategories = mongoOperation.findOne(searchUserCategoryQuery, UserCategories.class);
		ArrayList<UserCategoryArray> userCategoryArrays = uCategories.getUserCategoryArray();
		for(UserCategoryArray uCA: userCategoryArrays) {
			if(uCA.getCategoryName().equals(userCategories.getCategoryName())) {
				userCategoryArrays.remove(uCA);
				uCategories.setUserCategoryArray(userCategoryArrays);
				mongoOperation.save(uCategories);
				isDeleted=true;
				break;
			}
		}
		return isDeleted;
	}
	
	
	public UserCategories updateUserCat(UserCategories userCategories) {
		searchUserCategoryQuery
		= new Query(Criteria.where("userId").is(userCategories.getUserId()));
		UserCategories oldUserCategories = mongoOperation.findOne(searchUserCategoryQuery, UserCategories.class);
		ArrayList<UserCategoryArray> userCategoryArrays = oldUserCategories.getUserCategoryArray();
		for(UserCategoryArray uCA: userCategoryArrays) {
			if(uCA.getUserCategoriesId() == userCategories.getUserCategoriesId()) {
				UserCategoryArray uCA2 = uCA;
				uCA2.setCategoryName(userCategories.getCategoryName());
				userCategoryArrays.remove(uCA);
				userCategoryArrays.add(uCA2);
				oldUserCategories.setUserCategoryArray(userCategoryArrays);
				mongoOperation.save(oldUserCategories); 
				break;
			}
		}
		return oldUserCategories;
	}

}
