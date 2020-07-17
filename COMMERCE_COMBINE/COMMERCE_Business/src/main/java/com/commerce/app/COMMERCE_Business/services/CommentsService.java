package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Comments.*;

public interface CommentsService {

	public CommentsAddedEvent addComments(AddCommentsEvent addCommentsEvent);
	public CommentsDeletedEvent deleteComments(DeleteCommentsEvent deleteCommentsEvent);
	public CommentsGottenEvent getComments(GetCommentsEvent getCommentsEvent);
	public CommentsUpdatedEvent updateComments(UpdateCommentsEvent updateCommentsEvent);
}
