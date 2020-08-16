package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Category.CategoryDetails;

import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@XmlRootElement
public class Categories implements Serializable{
	
	@ApiModelProperty(notes = "Categories Id",name="categoriesId",required=true,value="test categories Id")
	private int categoriesId;
	@ApiModelProperty(notes = "name",name="name",required=true,value="test name")
	private String name;
	
	public CategoryDetails toCategoryDetails() {
		CategoryDetails cDetails = new CategoryDetails();
		
		return cDetails;
	}
	
	public Categories fromCategoryDetails() {
		Categories categories = new Categories();
		
		return categories;
	}
}
