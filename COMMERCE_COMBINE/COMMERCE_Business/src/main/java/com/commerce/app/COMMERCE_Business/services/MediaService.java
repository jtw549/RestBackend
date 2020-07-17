package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Media.*;

public interface MediaService {

	public MediaAddedEvent addMedia(AddMediaEvent addMediaEvent);
	public MediaDeletedEvent deleteMedia(DeleteMediaEvent deleteMediaEvent);
}
