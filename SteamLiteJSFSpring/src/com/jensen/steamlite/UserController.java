package com.jensen.steamlite;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import com.jensen.steamlite.model.entity.User;
import com.jensen.steamlite.service.UserService;

@ManagedBean
public class UserController {

	@ManagedProperty("#{userService}")
	private UserService userService;
	
	private User user;
	
	@Inject
	private UserHandler userHandler;
}
