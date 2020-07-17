package com.commerce.app.COMMERCE_Domain.repository;

import com.commerce.app.COMMERCE_Domain.domain.LoginEverythingDomain;
import com.commerce.app.COMMERCE_Domain.domain.Users;


public interface UserRepository{

	public Users registerUser(Users users) ;
	public LoginEverythingDomain loginUser (Users users,LoginEverythingDomain loginEverythingDomain);
	
}
