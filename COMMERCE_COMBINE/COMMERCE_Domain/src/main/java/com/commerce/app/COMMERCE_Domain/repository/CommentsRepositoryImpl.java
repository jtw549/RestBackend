package com.commerce.app.COMMERCE_Domain.repository;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.commerce.app.COMMERCE_Domain.config.SpringMongoConfig1;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.InventoryComments;

@Repository
public class CommentsRepositoryImpl implements CommentsRepository{
	
	ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	Query searchCommentsQuery;
	
	public ArrayList<InventoryComments> addComments(InventoryComments inventoryComments){
		Inventories inventories = mongoOperation.findById(inventoryComments.getInventoryId(), Inventories.class);
		ArrayList<InventoryComments> iComments = inventories.getInventoryComments();
		int size = iComments.size();
		if(size != 0) {
			InventoryComments lastComment =iComments.get(size-1);
			int lastId = lastComment.getInventoryCommentId();
			inventoryComments.setInventoryCommentId(lastId+1);
		}else {
			inventoryComments.setInventoryCommentId(inventoryComments.getInventoryId()+1);
		}
		
		iComments.add(inventoryComments);
		inventories.setInventoryComments(iComments);
		mongoOperation.save(inventories);
		return iComments;
	}
	
	public ArrayList<InventoryComments> deleteComments(InventoryComments inventoryComments){
		Inventories inventories = mongoOperation.findById(inventoryComments.getInventoryId(), Inventories.class);
		ArrayList<InventoryComments> iComments = inventories.getInventoryComments();
		iComments.remove(inventoryComments);
		inventories.setInventoryComments(iComments);
		mongoOperation.save(inventories);
		return iComments;
	}
	
	public ArrayList<InventoryComments> updateComments(InventoryComments inventoryComments){
		
		return null;
	}
	
	public ArrayList<InventoryComments> getComments(InventoryComments inventoryComments){
		
		return null;
	}
}
