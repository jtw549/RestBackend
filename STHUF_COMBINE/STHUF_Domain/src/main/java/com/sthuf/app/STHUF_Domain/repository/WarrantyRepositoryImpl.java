package com.sthuf.app.STHUF_Domain.repository;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sthuf.app.STHUF_Domain.config.SpringMongoConfig1;
import com.sthuf.app.STHUF_Domain.domain.Inventories;
import com.sthuf.app.STHUF_Domain.domain.InventoryWarranty;

@Repository
public class WarrantyRepositoryImpl implements WarrantyRepository{

	
	ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	Query searchWarrantyQuery;
	
	public ArrayList<InventoryWarranty> addWarranty(InventoryWarranty inventoryWarranty){
		searchWarrantyQuery = new Query(Criteria.where("userId").is(inventoryWarranty.getUserId())
				.andOperator(Criteria.where("inventoryId").is(inventoryWarranty.getInventoryId())));
		Inventories inventories = mongoOperation.findOne(searchWarrantyQuery, Inventories.class);
		ArrayList<InventoryWarranty> inventoryWarranties = inventories.getInventoryWarranty();
		int size = inventoryWarranties.size();
		if(size != 0) {
			InventoryWarranty lastWarranty = inventoryWarranties.get(size-1);
			int lastId = lastWarranty.getInventoryWarrantyid();
			inventoryWarranty.setInventoryWarrantyid(lastId+1);
		}else {
			inventoryWarranty.setInventoryWarrantyid(inventoryWarranty.getInventoryId()+1);
		}
		inventoryWarranties.add(inventoryWarranty);
		inventories.setInventoryWarranty(inventoryWarranties);
		mongoOperation.save(inventories);
		return inventoryWarranties;	
	}
	
	public ArrayList<InventoryWarranty> deleteWarranty(InventoryWarranty inventoryWarranty){
		searchWarrantyQuery = new Query(Criteria.where("userId").is(inventoryWarranty.getUserId())
				.andOperator(Criteria.where("inventoryId").is(inventoryWarranty.getInventoryId())));
		Inventories inventories = mongoOperation.findOne(searchWarrantyQuery, Inventories.class);
		ArrayList<InventoryWarranty> inventoryWarranties = inventories.getInventoryWarranty();
		inventoryWarranties.remove(inventoryWarranty);
		inventories.setInventoryWarranty(inventoryWarranties);
		mongoOperation.save(inventories);
		return inventoryWarranties;	
	}
	
	public ArrayList<InventoryWarranty> updateWarranty(InventoryWarranty inventoryWarranty){
		searchWarrantyQuery = new Query(Criteria.where("userId").is(inventoryWarranty.getUserId())
				.andOperator(Criteria.where("inventoryId").is(inventoryWarranty.getInventoryId())));
		Inventories inventories = mongoOperation.findOne(searchWarrantyQuery, Inventories.class);
		ArrayList<InventoryWarranty> inventoryWarranties = inventories.getInventoryWarranty();
		for (InventoryWarranty iw: inventoryWarranties) {
			if(iw.getInventoryWarrantyid()==inventoryWarranty.getInventoryWarrantyid()) {
				iw.setContactAddress(inventoryWarranty.getContactAddress());
				iw.setContactPhone(inventoryWarranty.getContactPhone());
				iw.setIssuer(inventoryWarranty.getIssuer());
				iw.setLength(inventoryWarranty.getLength());
				iw.setNotes(inventoryWarranty.getNotes());
				iw.setType(inventoryWarranty.getType());
				break;
			}
			
		}
		inventories.setInventoryWarranty(inventoryWarranties);
		mongoOperation.save(inventories);
		return inventoryWarranties;
	}
	
	public ArrayList<InventoryWarranty> getWarranty(InventoryWarranty inventoryWarranty){
		
		return null;
	}
}
