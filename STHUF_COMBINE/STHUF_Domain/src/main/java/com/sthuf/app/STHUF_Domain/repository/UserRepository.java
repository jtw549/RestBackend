package com.sthuf.app.STHUF_Domain.repository;

import com.sthuf.app.STHUF_Domain.domain.LoginEverythingDomain;
import com.sthuf.app.STHUF_Domain.domain.Users;


public interface UserRepository{

	public Users registerUser(Users users) ;
	public LoginEverythingDomain loginUser (Users users,LoginEverythingDomain loginEverythingDomain);
	
}
