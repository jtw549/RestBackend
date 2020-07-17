package com.commerce.app.COMMERCE_Domain.domain;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Categories")
public class Categories {

	@Id
	private int categoryId;
	
	private String name;
	
	private String createdDate;
	
	private ArrayList<String> subCategorys;
	

	public Categories () {
		
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public ArrayList<String> getSubCategorys() {
		return subCategorys;
	}

	public void setSubCategorys(ArrayList<String> subCategorys) {
		this.subCategorys = subCategorys;
	}
	
}
