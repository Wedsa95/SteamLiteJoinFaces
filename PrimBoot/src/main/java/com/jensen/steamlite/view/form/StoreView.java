

package com.jensen.steamlite.view.form;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jonas.steamlite.model.bean.StoreHandler;
import com.jonas.steamlite.model.entity.Game;


@ViewScoped
@Named("storeView")
public class StoreView implements Serializable{
	
	private static final long serialVersionUID = 5509801531320005038L;
	
	private List<Game> gamesList;
	
	@Inject
	private StoreHandler storeHandler; 
	
	@PostConstruct
	public void init() {
		gamesList = storeHandler.getGames();
	}

	public List<Game> getGamesList() {
		return gamesList;
	}
	public void setGamesList(List<Game> gamesList) {
		this.gamesList = gamesList;
	}

	public StoreHandler getStoreHandler() {
		return storeHandler;
	}
	public void setStoreHandler(StoreHandler storeHandler) {
		this.storeHandler = storeHandler;
	}
	
}
