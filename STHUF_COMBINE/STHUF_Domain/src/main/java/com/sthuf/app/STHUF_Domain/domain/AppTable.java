package com.sthuf.app.STHUF_Domain.domain;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AppTable")
public class AppTable {
	
	@Id
	private int appId;
	
	private int appValue;
	
	private String appClientName;
	
	private Timestamp createdTimestamp;
	
	private Timestamp updatedTimestamp;
	
	public AppTable () {
		
	}
	
	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getAppValue() {
		return appValue;
	}

	public void setAppValue(int appValue) {
		this.appValue = appValue;
	}

	public String getAppClientName() {
		return appClientName;
	}

	public void setAppClientName(String appClientName) {
		this.appClientName = appClientName;
	}

	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Timestamp getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	
	
}
