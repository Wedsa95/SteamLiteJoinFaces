package com.jensen.steamlite.model.entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
@Entity
@Table(name="user_have_achiev")
@ManagedBean(name="achievStatus")
public class AchievStatus  implements Serializable{
	//Rätt Annoterad
	private static final long serialVersionUID = -1127893160374144540L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_have_achiev_id")
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "user_have") 
	private User userState;
	
	@ManyToOne
    @JoinColumn(name = "have_achiev") 
	private Achievment achievState;
	
	@Column(name="achiev_unlocked")
	@Type(type="boolean")
	private Boolean achievUnlocked;
	
	public AchievStatus() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserState() {
		return userState;
	}

	public void setUserState(User userState) {
		this.userState = userState;
	}

	public Achievment getAchievState() {
		return achievState;
	}

	public void setAchievState(Achievment achievState) {
		this.achievState = achievState;
	}

	public Boolean getAchievUnlocked() {
		return achievUnlocked;
	}

	public void setAchievUnlocked(Boolean achievUnlocked) {
		this.achievUnlocked = achievUnlocked;
	}
	
}
