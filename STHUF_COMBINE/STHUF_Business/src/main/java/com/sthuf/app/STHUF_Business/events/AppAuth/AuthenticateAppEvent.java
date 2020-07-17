package com.sthuf.app.STHUF_Business.events.AppAuth;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.ReadEvent;

public class AuthenticateAppEvent extends ReadEvent{

	private ArrayList<String> appValues;
	
	public ArrayList<String> getAppValues() {
		return appValues;
	}

	public AuthenticateAppEvent(ArrayList<String> appValues) {
		this.appValues = appValues;
	}
}
