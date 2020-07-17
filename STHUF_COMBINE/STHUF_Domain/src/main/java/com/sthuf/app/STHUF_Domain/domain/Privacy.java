package com.sthuf.app.STHUF_Domain.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Privacy {

	@Id
	private int privacyId;
	
	private int userId;
	
	private String privacy;

	public Privacy() {
		
	}
	
	public int getPrivacyId() {
		return privacyId;
	}

	public void setPrivacyId(int privacyId) {
		this.privacyId = privacyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
}
