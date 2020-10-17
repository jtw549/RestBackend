package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Comments.*;

public interface CommentsService {

	public CommentsEvent addComments(CommentsEvent addCommentsEvent);
	public CommentsEvent deleteComments(CommentsEvent deleteCommentsEvent);
	public CommentsEvent getComments(CommentsEvent getCommentsEvent);
	public CommentsEvent updateComments(CommentsEvent updateCommentsEvent);
}
