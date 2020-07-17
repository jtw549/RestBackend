package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address implements Serializable{

	private int addressId;
	
	private int userId;
	
	private String address1;
	
	private String address2;
	
	private String city;
	
	private String state;

	private int zip;
	
	private String companyName;
}
