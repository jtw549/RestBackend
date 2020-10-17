package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Media.*;

public interface MediaService {

	public MediaEvent addMedia(MediaEvent addMediaEvent);
	public MediaEvent deleteMedia(MediaEvent deleteMediaEvent);
}
