package com.casestudy.stephen.landry.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {
	
	@Id
	@Size(min = 2, max = 20, message = "Username must be between {2} and {1}")
	private String name;
	@Column
	@Size(min = 2, max = 20, message = "Password must be between {2} and {1}")
	private String password;
	@Column
	private String email;
	@OneToMany(targetEntity = Game.class)
	private List<Game> gameLibrary;
	
	public User() {
		super();
		name = "";
		password = "";
		email = "";
		gameLibrary = null;
	}
	
	public User(String name, String password, String email, List<Game> gameLibrary) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.gameLibrary = gameLibrary;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			User other = (User) obj;
			boolean sameName = this.name.equals(other.getName());
			boolean samePassword = this.password.equals(other.getPassword());
			boolean sameEmail = this.email.equals(other.getEmail());
			if(sameName && samePassword && sameEmail)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Game> getGameLibrary() {
		return gameLibrary;
	}
	public void setGameLibrary(List<Game> gameLibrary) {
		this.gameLibrary = gameLibrary;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", email=" + email + ", gameLibrary=" + gameLibrary
				+ "]";
	}
}
