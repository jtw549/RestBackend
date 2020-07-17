package com.sthuf.app.STHUF_Business.services;

import com.sthuf.app.STHUF_Business.events.Comments.*;

public interface CommentsService {

	public CommentsAddedEvent addComments(AddCommentsEvent addCommentsEvent);
	public CommentsDeletedEvent deleteComments(DeleteCommentsEvent deleteCommentsEvent);
	public CommentsGottenEvent getComments(GetCommentsEvent getCommentsEvent);
	public CommentsUpdatedEvent updateComments(UpdateCommentsEvent updateCommentsEvent);
}
