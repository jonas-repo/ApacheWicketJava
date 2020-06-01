package com.wicket;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.wicket.models.UserModel;

public class UserSession extends WebSession{

	/**
	 * this class has the objective of store the user session by instance and get information into userModel
	 */
	
	private UserModel userModel;
	
	private static final long serialVersionUID = 1L;

	public UserSession(Request request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	public static UserSession getInstance() {
		return (UserSession) Session.get();
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
}
