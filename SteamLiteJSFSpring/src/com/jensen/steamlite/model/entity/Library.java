package com.jensen.steamlite.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="libraries")
@ManagedBean(name="library")
public class Library implements Serializable {
	
	private static final long serialVersionUID = -2911423518982507442L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="library_id")
	private int libraryId;
	
	
	@OneToOne
	@JoinColumn(name="owner")
	private User libraryOwner;
	
	@OneToMany
	@JoinTable(name="library_have_games",
			joinColumns=@JoinColumn(name="library_have"),
			inverseJoinColumns=@JoinColumn(name="have_game"))
	private List<Game> games;
	
	public Library() {
	}

	public void addGameToLibrary(Game game) {
		if(games == null) {
			games = new ArrayList<>();
		}
		games.add(game);
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public User getLibraryOwner() {
		return libraryOwner;
	}

	public void setLibraryOwner(User libraryOwner) {
		this.libraryOwner = libraryOwner;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
}
