

package com.jonas.steamlite.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.hibernate.Session;

import com.jonas.steamlite.model.database.DatabaseConnectionUtil;
import com.jonas.steamlite.model.entity.Game;


@ApplicationScoped
@Named
public class StoreHandler{
	
	private List<Game> games;
	
	public StoreHandler() {
		storeHandlerInit();
	}
	
	public void storeHandlerInit() {
		games = retrievAllGames();
	}
	
	public List<Game> getGames() {
		System.out.println("GetGames");
		return games;
	}

	public void setGames(List<Game> games) {
		System.out.println("SetGames");
		this.games = games;
	}
	
	@SuppressWarnings("unchecked")
	public List<Game> retrievAllGames(){
		System.out.println("RetrievAll");
		List<Game> tempGames = new ArrayList<Game>();
		
		try {
			Session session = DatabaseConnectionUtil
					.getSessionFactory().openSession();
			
//			tempGames = ((Object) session.createQuery("from Game"))
//					.getResultList();
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tempGames;
	}
	
}
