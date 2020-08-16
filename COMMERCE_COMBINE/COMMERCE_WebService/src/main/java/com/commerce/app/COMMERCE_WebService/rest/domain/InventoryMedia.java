package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.File;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Media.MediaDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
@JsonAutoDetect
public class InventoryMedia implements Serializable{

	@ApiModelProperty(notes = "Inventory medias id",name="inventoryMediasId",required=true,value="test inventory medias id")
	@JsonProperty(value="inventoryMediasId")
	private int inventoryMediasId;
	
	@ApiModelProperty(notes = "Inventory media type",name="mediaType",required=true,value="test inventory media type")
	@JsonProperty(value="mediaType")
	private String mediaType;
	
	@ApiModelProperty(notes = "Inventory media file name",name="fileName",required=true,value="test inventory media file name")
	@JsonProperty(value="fileName")
	private String fileName;
	
	@ApiModelProperty(notes = "Inventory media link",name="mediaLink",required=true,value="test inventory media link")
	@JsonProperty(value="mediaLink")
	private String mediaLink;
	
	@ApiModelProperty(notes = "Inventory media file",name="mediaFile",required=true,value="test media file")
	@JsonProperty(value="mediaFile")
	private File mediaFile;
	
	@ApiModelProperty(notes = "Inventory Id associated with inventory media",name="inventoryId",required=true,value="test inventory id")
	@JsonProperty(value="inventoryId")
	private int inventoryId;
	
	@ApiModelProperty(notes = "User Id associated with inventory media",name="userId",required=true,value="test user id")
	@JsonProperty(value="userId")
	private int userId;
	
	
	public MediaDetails toMediaDetails() {
		MediaDetails mediaDetails = new MediaDetails();
		mediaDetails.setFileName(fileName);
		mediaDetails.setInventoryId(inventoryId);
		mediaDetails.setInventoryMediasId(inventoryMediasId);
		mediaDetails.setMediaLink(mediaLink);
		mediaDetails.setMediaType(mediaType);
		mediaDetails.setUserId(userId);
		return mediaDetails;
	}
	
	public InventoryMedia fromMediaDetails(MediaDetails mediaDetails) {
		InventoryMedia inventoryMedias = new InventoryMedia();
		inventoryMedias.fileName = mediaDetails.getFileName();
		inventoryMedias.inventoryId = mediaDetails.getInventoryId();
		inventoryMedias.inventoryMediasId = mediaDetails.getInventoryMediasId();
		inventoryMedias.mediaLink = mediaDetails.getMediaLink();
		inventoryMedias.mediaType = mediaDetails.getMediaType();
		inventoryMedias.userId = mediaDetails.getUserId();
		return inventoryMedias;
	}

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
	
	
}
