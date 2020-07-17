package com.commerce.app.COMMERCE_Business.events.Media;

import java.io.File;
import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.InventoryMedia;

public class MediaDetails {

	private int inventoryMediasId;
	
	private String mediaType;
	
	private String fileName;
	
	private String mediaLink;
	
	private File mediaFile;
	
	private int inventoryId;
	
	private int userId;
	
	private ArrayList<InventoryMedia> inventoryMediasList;

	public int getInventoryMediasId() {
		return inventoryMediasId;
	}

	public void setInventoryMediasId(int inventoryMediasId) {
		this.inventoryMediasId = inventoryMediasId;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMediaLink() {
		return mediaLink;
	}

	public void setMediaLink(String mediaLink) {
		this.mediaLink = mediaLink;
	}

	public File getMediaFile() {
		return mediaFile;
	}

	public void setMediaFile(File mediaFile) {
		this.mediaFile = mediaFile;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public MediaDetails toMediaDetails(ArrayList<InventoryMedia> inventoryMedia,MediaDetails mediaDetails) {
		mediaDetails.setInventoryMediasList(inventoryMedia);
		return null;
	}
	
	public MediaDetails toMediaDetails(InventoryMedia inventoryMedia,MediaDetails mediaDetails) {
		mediaDetails.setFileName(inventoryMedia.getFileName());
		mediaDetails.setInventoryId(inventoryMedia.getInventoryId());
		mediaDetails.setInventoryMediasId(inventoryMedia.getInventoryMediaId());
		mediaDetails.setMediaLink(inventoryMedia.getMediaLink());
		mediaDetails.setMediaType(inventoryMedia.getMediaType());
		mediaDetails.setUserId(inventoryMedia.getUserId());
		return mediaDetails;
	}
	
	public InventoryMedia fromMediaDetails() {
		InventoryMedia inventoryMedias = new InventoryMedia();
		inventoryMedias.setFileName(fileName);
		inventoryMedias.setInventoryId(inventoryId);
		inventoryMedias.setInventoryMediaId(inventoryMediasId);
		inventoryMedias.setMediaLink(mediaLink);
		inventoryMedias.setMediaType(mediaType);
		inventoryMedias.setUserId(userId);
		return inventoryMedias;
	}

	public ArrayList<InventoryMedia> getInventoryMediasList() {
		return inventoryMediasList;
	}

	public void setInventoryMediasList(ArrayList<InventoryMedia> inventoryMediasList) {
		this.inventoryMediasList = inventoryMediasList;
	}

}
