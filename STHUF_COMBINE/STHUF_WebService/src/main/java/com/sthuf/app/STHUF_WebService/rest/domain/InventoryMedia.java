package com.sthuf.app.STHUF_WebService.rest.domain;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sthuf.app.STHUF_Business.events.Media.MediaDetails;

@XmlRootElement
@JsonAutoDetect
public class InventoryMedia implements Serializable{

	@JsonProperty(value="position")
	private int position;
	
	@JsonProperty(value="formula")
	private String formula;
	
	@JsonProperty(value="inventoryMediasId")
	private int inventoryMediasId;
	
	@JsonProperty(value="mediaType")
	private String mediaType;
	
	@JsonProperty(value="fileName")
	private String fileName;
	
	@JsonProperty(value="mediaLink")
	private String mediaLink;
	
	@JsonProperty(value="mediaFile")
	private File mediaFile;
	
	@JsonProperty(value="inventoryId")
	private int inventoryId;
	
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
	
	public ArrayList<String> appVerify(){
		ArrayList<String> appValues = new ArrayList<String>();
		appValues.add(formula);
		appValues.add(String.valueOf(position));
		return appValues;
		
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
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
