package com.jensen.steamlite.model.bean;

import com.jensen.steamlite.model.entity.User;

public class ResidingUser {
	
	private User user;


	public ResidingUser(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
