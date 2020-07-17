package com.sthuf.app.STHUF_Business.services;

import com.sthuf.app.STHUF_Business.events.Media.*;

public interface MediaService {

	public MediaAddedEvent addMedia(AddMediaEvent addMediaEvent);
	public MediaDeletedEvent deleteMedia(DeleteMediaEvent deleteMediaEvent);
}
