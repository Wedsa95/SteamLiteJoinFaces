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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="games")
@ManagedBean(name="game")
public class Game implements Serializable {
	
	private static final long serialVersionUID = 5958958094046147635L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="game_id")
	private int gameId;
	
	@Column(name="game_name")
	private String gameName;
	
	@Column(name="game_app_id")
	private int gameAppId;
	
	@ManyToOne
	@JoinTable(name="library_have_games",
		joinColumns=@JoinColumn(name="have_game"),
		inverseJoinColumns=@JoinColumn(name="library_have"))
	private Library belongsTo;
	
	@OneToMany(mappedBy="ratingSubject")
	private List<Rating> rating;
	
	@ManyToMany
	@JoinTable(name="categories_for_games",
		joinColumns=@JoinColumn(name="for_games"),
		inverseJoinColumns=@JoinColumn(name="categories_for"))
	private List<Category> categories;
	
	
	@OneToMany(mappedBy="achievGame")
	private List<Achievment> Achivments;
	
	public Game() {
		
	}

	public void addCategoryToGames(Category category) {
		if(categories == null) {
			categories = new ArrayList<>();
		}
		categories.add(category);
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getGameAppId() {
		return gameAppId;
	}

	public void setGameAppId(int gameAppId) {
		this.gameAppId = gameAppId;
	}

	public Library getBelongsTo() {
		return belongsTo;
	}

	public void setBelongsTo(Library belongsTo) {
		this.belongsTo = belongsTo;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Achievment> getAchivments() {
		return Achivments;
	}

	public void setAchivments(List<Achievment> achivments) {
		Achivments = achivments;
	}

	@Override
	public String toString() {
		return gameName;
	}
	
}
