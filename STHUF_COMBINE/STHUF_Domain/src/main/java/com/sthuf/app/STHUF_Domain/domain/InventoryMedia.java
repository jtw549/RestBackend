package com.sthuf.app.STHUF_Domain.domain;

import java.io.File;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InventoryMedia {

	@Id
	private int inventoryMediaId;
	
	private String mediaType;
	
	private String fileName;
	
	private String mediaLink;
	
	private File mediaFile;
	
	private int inventoryId;
	
	private int userId;
	
	public InventoryMedia() {
		
	}

	public int getInventoryMediaId() {
		return inventoryMediaId;
	}

	public void setInventoryMediaId(int inventoryMediaId) {
		this.inventoryMediaId = inventoryMediaId;
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
}
