package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Users.UserEvent;

public interface UsersService {

	public UserEvent registerUser(UserEvent registerUserEvent);
	public UserEvent updateUser(UserEvent updateUserEvent);
	public boolean deleteUser(UserEvent deleteUserEvent);
	public UserEvent getAccountInfo(UserEvent getUserAccountInfoEvent);
	public UserEvent loginUser(UserEvent loginUserEvent);
	public boolean logoutUser(UserEvent loginUserEvent);
}
