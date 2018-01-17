package com.jonas.steamlite.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="achievments")
@ManagedBean(name="achievment")
public class Achievment implements Serializable{

	private static final long serialVersionUID = 8664299405716442198L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="achiev_id")
	private int achievId;
	
	@ManyToOne
	@JoinColumn(name="game_with_achiev")
	private Game achievGame;
	
	@Column(name="achiev_name")
	private String achievName;
	
	@Column(name="achiev_point")
	private int achievPoint;
	
	@OneToMany(mappedBy="achievState")
	private List<AchievStatus> achiveStatuses;

	public Achievment() {
	}
	//HJÄLP METOD 
	public int getAchievId() {
		return achievId;
	}

	public void setAchievId(int achievId) {
		this.achievId = achievId;
	}

	public Game getAchievGame() {
		return achievGame;
	}

	public void setAchievGame(Game achievGame) {
		this.achievGame = achievGame;
	}

	public String getAchievName() {
		return achievName;
	}

	public void setAchievName(String achievName) {
		this.achievName = achievName;
	}

	public int getAchievPoint() {
		return achievPoint;
	}

	public void setAchievPoint(int achievPoint) {
		this.achievPoint = achievPoint;
	}

	public List<AchievStatus> getAchiveStatuses() {
		return achiveStatuses;
	}

	public void setAchiveStatuses(List<AchievStatus> achiveStatuses) {
		this.achiveStatuses = achiveStatuses;
	}

	@Override
	public String toString() {
		return "Achievment [achievName=" + achievName + "]";
	}
	
}
