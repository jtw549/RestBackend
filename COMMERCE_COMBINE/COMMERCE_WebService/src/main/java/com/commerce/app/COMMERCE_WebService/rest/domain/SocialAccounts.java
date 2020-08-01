package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SocialAccounts implements Serializable{

	private int userId;
	
	private boolean hasSocialAccount;
	
}
