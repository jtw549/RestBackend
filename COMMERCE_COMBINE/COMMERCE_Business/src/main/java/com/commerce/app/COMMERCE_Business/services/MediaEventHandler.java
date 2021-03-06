package com.commerce.app.COMMERCE_Business.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.Media.MediaEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryMedia;
import com.commerce.app.COMMERCE_Domain.repository.MediaRepository;

@Service("mediaService")
@ComponentScan("com.commerce.app.COMMERCE_Domain.repository")
public class MediaEventHandler implements MediaService{
	
	private static Logger LOG = LoggerFactory.getLogger(MediaEventHandler.class);
	
	@Autowired
	private MediaRepository mediaRepository;
	
	@Override
	public MediaEvent addMedia(MediaEvent addMediaEvent) {
		InventoryMedia inventoryMedia = addMediaEvent.getMediaDetails().fromMediaDetails();
		ArrayList<InventoryMedia> inventoryMedias = mediaRepository.addMedias(inventoryMedia);
		return new MediaEvent(inventoryMedias);
	}
	
	@Override
	public MediaEvent deleteMedia(MediaEvent deleteMediaEvent) {
		InventoryMedia inventoryMedia = deleteMediaEvent.getMediaDetails().fromMediaDetails();
		boolean deleted = mediaRepository.deleteMedias(inventoryMedia);
		return new MediaEvent(deleted);
	}
}
