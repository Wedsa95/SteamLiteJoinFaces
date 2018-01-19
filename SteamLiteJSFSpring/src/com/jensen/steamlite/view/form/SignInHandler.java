package com.jensen.steamlite.view.form;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jensen.steamlite.UserHandler;

@RequestScoped
@Named
public class SignInHandler {

	private String username;
	private String password;
	
	@Inject
	private UserHandler userHandler;

	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String sendTo() {
		return userHandler.signIn(username, password);
	}
}
