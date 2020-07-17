package com.commerce.app.COMMERCE_Domain.repository;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.commerce.app.COMMERCE_Domain.config.SpringMongoConfig1;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.InventoryMedia;

@Repository
public class MediaRepositoryImpl implements MediaRepository{

	ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	Query inventoryMediaQuery;
	
	@Autowired
	SequenceRepository sequenceRepository;
	
	@Autowired
	SdeleteRepository sdeleteRepository;
	
	@Autowired
	SuploadRepository suploadRepository;
	
	public ArrayList<InventoryMedia> addMedias(InventoryMedia inventoryMedia){
		inventoryMedia.setInventoryMediaId((int) sequenceRepository.getNextSequenceId("mediaID_Sequence"));
		long mediaLinkId = sequenceRepository.getNextSequenceId("mediaID_Sequence");
		if("image".equals(inventoryMedia.getMediaType())) {
			inventoryMedia.setMediaLink("http://d394ru73751rqx.cloudfront.net/"+
					mediaLinkId+inventoryMedia.getFileName());//fill in the link
		}else {
			inventoryMedia.setMediaLink("http://s1elc0ueb8hj24.cloudfront.net/"+
					mediaLinkId+inventoryMedia.getFileName());//fill in the link
		}
		inventoryMedia.setFileName(""+mediaLinkId
		+inventoryMedia.getFileName());
		inventoryMediaQuery = new Query(Criteria.where("inventoryId").is(inventoryMedia.getInventoryId())
				.andOperator(Criteria.where("userId").is(inventoryMedia.getUserId())));
		Inventories inventories = mongoOperation.findOne(inventoryMediaQuery, Inventories.class);
		ArrayList<InventoryMedia> inventoryMedias = inventories.getInventoryMedias();
		inventoryMedias.add(inventoryMedia);
		inventories.setInventoryMedias(inventoryMedias);
		mongoOperation.save(inventories);
		try {
			suploadRepository.uploadMedia(inventoryMedia.getMediaType(), inventoryMedia.getMediaFile(), 
					""+mediaLinkId+inventoryMedia.getFileName(), inventoryMedia.getUserId(), inventoryMedia.getInventoryId());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inventoryMedias;
	}
	
	public boolean deleteMedias(InventoryMedia inventoryMedia) {
		inventoryMediaQuery = new Query(Criteria.where("inventoryId").is(inventoryMedia.getInventoryId())
				.andOperator(Criteria.where("userId").is(inventoryMedia.getUserId())));
		Inventories inventories = mongoOperation.findOne(inventoryMediaQuery, Inventories.class);
		ArrayList<InventoryMedia> inventoryMedias = inventories.getInventoryMedias();
		inventoryMedias.remove(inventoryMedia);
		inventories.setInventoryMedias(inventoryMedias);
		mongoOperation.save(inventories);
		try {
			sdeleteRepository.deleteMedia(inventoryMedia.getMediaType(), inventoryMedia.getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
