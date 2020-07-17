package com.commerce.app.COMMERCE_Domain.repository;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.UserCategories;

public interface CategoryRepository{

	public UserCategories addUserCat(UserCategories userCategories);
	public boolean deleteUserCat(UserCategories userCategories);
	public UserCategories updateUserCat(UserCategories userCategories);
	
}
