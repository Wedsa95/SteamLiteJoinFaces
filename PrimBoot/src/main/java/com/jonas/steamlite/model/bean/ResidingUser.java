package com.jonas.steamlite.model.bean;

import java.io.Serializable;

import com.jonas.steamlite.model.entity.User;

public class ResidingUser implements Serializable{
	
	private static final long serialVersionUID = 5021130215165660530L;
	private User user;


	public ResidingUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
