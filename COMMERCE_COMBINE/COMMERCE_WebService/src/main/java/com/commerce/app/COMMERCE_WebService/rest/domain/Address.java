package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@XmlRootElement
public class Address implements Serializable{

	@ApiModelProperty(notes = "Address Id",name="addressId",required=true,value="test addressId")
	private int addressId;
	
	@ApiModelProperty(notes = "User Id",name="userId",required=true,value="test userId")
	private int userId;
	
	@ApiModelProperty(notes = "Address 1",name="address1",required=true,value="test address1")
	private String address1;
	
	@ApiModelProperty(notes = "Address 2",name="address2",required=true,value="test address2")
	private String address2;
	
	@ApiModelProperty(notes = "Name of the city",name="city",required=true,value="test city")
	private String city;
	
	@ApiModelProperty(notes = "Name of the state",name="state",required=true,value="test state")
	private String state;
	
	@ApiModelProperty(notes = "Zip",name="zip",required=true,value="test zip")
	private String zip;
	
	@ApiModelProperty(notes = "Name of the company",name="companyName",required=true,value="test companyName")
	private String companyName;
}
