package com.jonas.steamlite.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedNativeQueries({
	@NamedNativeQuery(
	name = "GET_USER_BY_NAME",
	query = "SELECT * FROM users WHERE user_name = :name",
	resultClass = User.class		
	)
})

@Entity
@Table(name="users")
@ManagedBean(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = -6044766768034805748L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_password")
	private String userPassword;
	
	@OneToOne(mappedBy = "libraryOwner")
	private Library library;
	
	@OneToMany(mappedBy="userState")
	private List<AchievStatus> achievStatuses;
	
	@OneToMany(mappedBy="ratingCritic")
	private List<Rating> ratings;
	
	public User() {
	}
	
	//HJÄLP METODER FÖR ATT LÄGGA TILL OCH HÄMTA 
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public List<AchievStatus> getAchievStatuses() {
		return achievStatuses;
	}

	public void setAchievStatuses(List<AchievStatus> achievStatuses) {
		this.achievStatuses = achievStatuses;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return userName;
	}
	
}
