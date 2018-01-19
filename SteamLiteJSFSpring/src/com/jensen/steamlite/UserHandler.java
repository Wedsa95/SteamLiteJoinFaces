package com.jensen.steamlite;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.jensen.steamlite.model.bean.ResidingUser;
import com.jensen.steamlite.model.entity.Library;
import com.jensen.steamlite.model.entity.User;
import com.jensen.steamlite.model.security.CrypteUtil;
import com.jensen.steamlite.service.UserService;

@Named
@SessionScoped
public class UserHandler implements Serializable {

	private static final long serialVersionUID = -6114578562850663408L;

	@ManagedProperty("#{userService}")
	private UserService userService;
	
	private ResidingUser residingUser = null;
	
	private CrypteUtil hasher = new CrypteUtil();

	public ResidingUser getResidingUser() {
		return residingUser;
	}

	public void setResidingUser(ResidingUser residingUser) {
		this.residingUser = residingUser;
	}
	
	
	public CrypteUtil getHasher() {
		return hasher;
	}

	public void setHasher(CrypteUtil hasher) {
		this.hasher = hasher;
	}

	public boolean isSignedIn() {
		return residingUser != null;
	}
	
	public String signIn(String username, String password) {

		System.out.println("In Sign INN");
		User user = new User();

		user = getUserByUserName(username);

		
		
		if (user.getUserName() == username && hasher.checkPassword(password, user.getUserPassword())) {
			residingUser = new ResidingUser(user);

			return "/faces/store.xhtml?faces-redirect=true";

		} else {
			FacesMessage message = new FacesMessage("Wrong User Name or Password");
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, message);

			return "/faces/login.xhtml";
		}
	}

	

	public String signOut() {
		System.out.println("In Sign out");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/faces/store.xhtml?faces-redirect=true";
	}

	public void destroySession() {
		System.out.println("In Destroy");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public String signUp(String userName, String password, String email) {

		System.out.println("In Sign UPP");
		User user = new User();

		user = getUserByUserName(userName);

		if (userName != user.getUserName()) {

			createNewUser(userName, password, email);

			destroySession();
			return "/faces/login.xhtml";

		} else {

			FacesMessage message = new FacesMessage("User name already exists!");
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, message);

			destroySession();
			return "/faces/signup.xhtml";
		}

	}
	
	public String updateInfo(String userName, String password, String email) {
		String newPassword = hashPassword(password);
		User user = residingUser.getUser();
		
		updateUser(userName, email, newPassword, user);

		destroySession();
		return "/faces/login.xhtml";
	}

	private void updateUser(String userName, String email, String newPassword, User user) {
	
		userService.updateUser(userName, email, newPassword, user);
	}

	public String deleteUser() {
		deleteResidingUser();
		destroySession();

		return "/faces/login.xhtml";
	}
	
	private String hashPassword(String password) {
		String hashWord = hasher.newSaltAndHach(password);
		return hashWord;
	}

	private User getUserByUserName(String userName) {
		User user = new User();
		UserService userService = new UserService();
		try {
			user = userService.getUserByUserName(userName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}
	
	private void createNewUser(String userName, String password, String email) {
		User newUser = new User();
		
		String hashWord = hashPassword(password);

		newUser.setUserName(userName);
		newUser.setUserEmail(email);
		newUser.setUserPassword(hashWord);
		newUser.setLibrary(new Library());

		userService.createUser(newUser);
		
	}
	private void deleteResidingUser() {
	
		User deleteUser = residingUser.getUser();
		userService.deleteUser(deleteUser);
	}

}
