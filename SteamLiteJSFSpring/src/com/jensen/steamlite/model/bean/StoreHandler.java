

package com.jensen.steamlite.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jensen.steamlite.model.entity.Game;


@RequestScoped
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
		
		tempGames = retrievAllGames(tempGames);
		
		return tempGames;
	}

	private List<Game> retrievAllGames(List<Game> tempGames) {
		
		return tempGames;
	}
	
}
