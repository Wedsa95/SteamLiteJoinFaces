

package com.jonas.steamlite.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;

import com.jonas.steamlite.model.database.DatabaseConnectionUtil;
import com.jonas.steamlite.model.entity.Game;
import com.jonas.steamlite.model.entity.Library;
import com.jonas.steamlite.model.entity.User;

@Named(value="libraryHandler")
@ViewScoped
public class LibraryHandler {

	private List<Game> games;
	
	@Inject
	private UserHandler residingUserHandler; 

	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	@PostConstruct
	public void initGamesList() {
		System.out.println("IN INIT GAME LIST");
		if(checkGameList()) {
			retrieveGamesList();
		}else {
			createLibraryForUser();
			retrieveGamesList();
		}
	}
	
	public boolean checkGameList() {
		System.out.println("IN CHECK GAME LIST");
		User tempUser = null;
		try {
			Session session = DatabaseConnectionUtil.getSessionFactory().openSession();
			
			tempUser = session.get(User.class, residingUserHandler.getResidingUser().getUser().getUserId());
			tempUser.getLibrary();
			tempUser.getLibrary().getGames();
			tempUser.getLibrary().getGames().forEach(e -> e.getCategories());
			tempUser.getLibrary().getGames().forEach(e -> e.getAchivments());
			tempUser.getLibrary().getGames().forEach(e -> e.getRating());
			
			session.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(tempUser.getLibrary().equals(null)) {
			return false;
		}else {
			return true;
		}
	}
	
	public void createLibraryForUser() {
		System.out.println("IN CREATE LIBRARY For USER");
		User createLibraryUser = null;
		Library createLibrary = null;
		try {
			Session createLibrarySession = DatabaseConnectionUtil.getSessionFactory().openSession();
			
				createLibraryUser = createLibrarySession.get(User.class
						,residingUserHandler.getResidingUser().getUser().getUserId());
				
				createLibrary = new Library();
				createLibrary.setLibraryOwner(createLibraryUser);
				
				createLibraryUser.setLibrary(createLibrary);
			
				createLibrarySession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void retrieveGamesList(){
		System.out.println("IN RETREVE GAMELIST");
		
		games = new ArrayList<>();
		User tempUser = null;
		try {
			Session session = DatabaseConnectionUtil.getSessionFactory().openSession();
			
			tempUser = session.get(User.class, residingUserHandler.getResidingUser().getUser().getUserId());
			tempUser.getLibrary();
			tempUser.getLibrary().getGames();
			tempUser.getLibrary().getGames().forEach(e -> e.getCategories());
			tempUser.getLibrary().getGames().forEach(e -> e.getAchivments());
			tempUser.getLibrary().getGames().forEach(e -> e.getRating());
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Game game: tempUser.getLibrary().getGames()) {
			games.add(game);
		}
	}
	
}
