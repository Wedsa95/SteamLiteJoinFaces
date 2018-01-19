package com.jensen.steamlite.view.form;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jensen.steamlite.UserHandler;

@RequestScoped
@Named
public class SignOutHandler {
	
	@Inject
	private UserHandler userHandler;

	public String sendTo() {
		return userHandler.signOut();
	}
}
