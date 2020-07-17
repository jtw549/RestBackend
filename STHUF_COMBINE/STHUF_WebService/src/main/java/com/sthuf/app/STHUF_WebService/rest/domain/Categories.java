package com.sthuf.app.STHUF_WebService.rest.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.sthuf.app.STHUF_Business.events.Category.CategoryDetails;

@XmlRootElement
public class Categories implements Serializable{
	//should probably already be on the front end
	private int categoriesId;
	
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
