package com.sthuf.app.STHUF_Domain.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SocialAccounts {

	private int userId;
	
	private boolean facebook;
	
	private boolean twitter;
	
	private boolean tumblr;
	
	private boolean other;
}
