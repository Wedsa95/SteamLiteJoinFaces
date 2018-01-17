package com.jonas.steamlite.model.entity;

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
import javax.persistence.Table;

@Entity
@Table(name="categories")
@ManagedBean(name="category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = -8013869256143217956L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="categories_id" )
	private int categoryId;
	
	@Column(name="categories_name")
	private String categoryName;
	
	@ManyToMany
	@JoinTable(name="categories_for_games",
		joinColumns=@JoinColumn(name="categories_for" ),
		inverseJoinColumns=@JoinColumn(name="for_games"))
	private List<Game> theGames;
	
	public Category() {
	}
	
	public void addGameToCategories(Game game) {
		if(theGames == null) {
			theGames = new ArrayList<>();
		}
		theGames.add(game);
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Game> getTheGames() {
		return theGames;
	}

	public void setTheGames(List<Game> theGames) {
		this.theGames = theGames;
	}

	@Override
	public String toString() {
		return categoryName;
	} 
	
}
