package com.sthuf.app.STHUF_Domain.repository;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Domain.domain.UserCategories;

public interface CategoryRepository{

	public UserCategories addUserCat(UserCategories userCategories);
	public boolean deleteUserCat(UserCategories userCategories);
	public UserCategories updateUserCat(UserCategories userCategories);
	
}
