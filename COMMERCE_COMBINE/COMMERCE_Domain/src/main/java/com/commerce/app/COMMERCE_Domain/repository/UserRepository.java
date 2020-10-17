package com.commerce.app.COMMERCE_Domain.repository;

import com.commerce.app.COMMERCE_Domain.domain.LoginEverythingDomain;
import com.commerce.app.COMMERCE_Domain.domain.Users;


public interface UserRepository{

	public Users registerUser(Users users);
	public Users updateUser(Users users);
	public boolean deleteUser(Users users);
	public Users getAccountInfo(Users users);
	public boolean logoutUser(Users users);
	public LoginEverythingDomain loginUser (Users users,LoginEverythingDomain loginEverythingDomain);
	
}
