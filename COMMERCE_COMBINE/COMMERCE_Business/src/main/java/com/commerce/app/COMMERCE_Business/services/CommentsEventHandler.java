package com.commerce.app.COMMERCE_Business.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.Comments.*;
import com.commerce.app.COMMERCE_Domain.domain.Inventories;
import com.commerce.app.COMMERCE_Domain.domain.InventoryComments;
import com.commerce.app.COMMERCE_Domain.repository.CommentsRepository;

@Service("commentsService")
@ComponentScan("com.sthuf.app.STHUF_Domain.repository")
public class CommentsEventHandler implements CommentsService{

	private static Logger LOG = LoggerFactory.getLogger(CommentsEventHandler.class);
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	@Override
	public CommentsAddedEvent addComments(AddCommentsEvent addCommentsEvent) {
		InventoryComments inventoryComments = addCommentsEvent.getCommentsDetails().fromCommentsDetails();
		ArrayList<InventoryComments> iComments = commentsRepository.addComments(inventoryComments);
		return new CommentsAddedEvent(iComments);
	}
	
	@Override
	public CommentsDeletedEvent deleteComments(DeleteCommentsEvent deleteCommentsEvent) {
		InventoryComments inventoryComments = deleteCommentsEvent.getCommentsDetails().fromCommentsDetails();
		ArrayList<InventoryComments> iComments = commentsRepository.deleteComments(inventoryComments);
		return new CommentsDeletedEvent(iComments);
	}
	
	@Override
	public CommentsGottenEvent getComments(GetCommentsEvent getCommentsEvent) {
		//Added just in case
		InventoryComments inventoryComments = getCommentsEvent.getCommentsDetails().fromCommentsDetails();
		ArrayList<InventoryComments> iComments = commentsRepository.getComments(inventoryComments);
		return new CommentsGottenEvent(inventoryComments);
	}
	
	@Override
	public CommentsUpdatedEvent updateComments(UpdateCommentsEvent updateCommentsEvent) {
		//Added just in case
		InventoryComments inventoryComments = updateCommentsEvent.getCommentsDetails().fromCommentsDetails();
		ArrayList<InventoryComments> iComments = commentsRepository.updateComments(inventoryComments);
		return new CommentsUpdatedEvent(inventoryComments);
	}
}
