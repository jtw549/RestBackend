package com.commerce.app.COMMERCE_Domain.repository;

import java.util.ArrayList;

import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.commerce.app.COMMERCE_Domain.config.SpringMongoConfig1;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.InventoryNotes;

@Repository
public class NotesRepositoryImpl implements NotesRepository{

	ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	Query searchNotesQuery;
	
	public ArrayList<InventoryNotes> addNotes(InventoryNotes inventoryNotes){
		searchNotesQuery = new Query(Criteria.where("inventoryId").is(inventoryNotes.getInventoryId())
				.andOperator(Criteria.where("userId").is(inventoryNotes.getUserId())));
		Inventories inventories = mongoOperation.findOne(searchNotesQuery, Inventories.class);
		ArrayList<InventoryNotes> iNotes = inventories.getInventoryNotes();
		int size = iNotes.size();
		if(size != 0) {
			InventoryNotes lastNotes = iNotes.get(size-1);
			int lastId = lastNotes.getInventoryNotesId();
			inventoryNotes.setInventoryNotesId(lastId+1);
		}else {
			inventoryNotes.setInventoryNotesId(inventoryNotes.getInventoryId()+1);
		}
		iNotes.add(inventoryNotes);
		inventories.setInventoryNotes(iNotes);
		mongoOperation.save(inventories);
		return iNotes;
	}
	public ArrayList<InventoryNotes> deleteNotes(InventoryNotes inventoryNotes){
		searchNotesQuery = new Query(Criteria.where("inventoryId").is(inventoryNotes.getInventoryId())
				.andOperator(Criteria.where("userId").is(inventoryNotes.getUserId())));
		Inventories inventories = mongoOperation.findOne(searchNotesQuery, Inventories.class);
		ArrayList<InventoryNotes> iNotes = inventories.getInventoryNotes();
		iNotes.remove(inventoryNotes);
		inventories.setInventoryNotes(iNotes);
		mongoOperation.save(inventories);
		return iNotes;
	}
	public ArrayList<InventoryNotes> getNotes(InventoryNotes inventoryNotes){
		searchNotesQuery = new Query(Criteria.where("inventoryId").is(inventoryNotes.getInventoryId())
				.andOperator(Criteria.where("userId").is(inventoryNotes.getUserId())));
		Inventories inventories = mongoOperation.findOne(searchNotesQuery, Inventories.class);
		ArrayList<InventoryNotes> iNotes = inventories.getInventoryNotes();
		return null;
	}
	public ArrayList<InventoryNotes> updateNotes(InventoryNotes inventoryNotes){
		searchNotesQuery = new Query(Criteria.where("inventoryId").is(inventoryNotes.getInventoryId())
				.andOperator(Criteria.where("userId").is(inventoryNotes.getUserId())));
		Inventories inventories = mongoOperation.findOne(searchNotesQuery, Inventories.class);
		ArrayList<InventoryNotes> iNotes = inventories.getInventoryNotes();
		for(InventoryNotes inventNotes : iNotes) {
			if(inventNotes.getInventoryNotesId() == inventoryNotes.getInventoryNotesId()) {
				iNotes.remove(inventNotes);
				iNotes.add(inventoryNotes);
				break;
			}
		}
		inventories.setInventoryNotes(iNotes);
		mongoOperation.save(inventories);
		return null;
	}
	
}
