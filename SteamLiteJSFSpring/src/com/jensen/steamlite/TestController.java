package com.jensen.steamlite;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import com.jensen.steamlite.model.entity.User;
import com.jensen.steamlite.service.UserService;

@ManagedBean
public class TestController {

	@ManagedProperty("#{userService}")
	private UserService userService;
	
	private User user;
	
	@PostConstruct
	public void loadUser() {
		user = userService.getUserOne();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
