package com.sthuf.app.STHUF_Business.services;

import com.sthuf.app.STHUF_Business.events.Users.*;

public interface UsersService {

	public UserRegisteredEvent registerUser(RegisterUserEvent registerUserEvent);
	public UserUpdatedEvent updateUser(UpdateUserEvent updateUserEvent);
	public UserDeletedEvent deleteUser(DeleteUserEvent deleteUserEvent);
	public UserAccountInfoGottenEvent getAccountInfo(GetUserAccountInfoEvent getUserAccountInfoEvent);
	public UserLoggedInEvent loginUser(LoginUserEvent loginUserEvent);
	public UserLoggedOutEvent logoutUser(LoginUserEvent loginUserEvent);
}
