package com.jensen.steamlite.view.form;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jonas.steamlite.model.bean.UserHandler;

@RequestScoped
@Named
public class SignInHandler {

	private String userName;
	private String password;
	
	@Inject
	private UserHandler userHandler;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String sendTo() {
		return userHandler.signIn(userName, password);
	}
}
