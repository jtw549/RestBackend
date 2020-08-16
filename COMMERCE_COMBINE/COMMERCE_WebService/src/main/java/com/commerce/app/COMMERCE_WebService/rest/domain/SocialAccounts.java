package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SocialAccounts implements Serializable{
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	private int userId;
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	private boolean hasSocialAccount;
	
}
