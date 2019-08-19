package com.casestudy.stephen.landry.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(query="select e from Game e", name="GetAllGames")
public class Game {
	@Id
	private String name;
	@Column
	private String platform;
	@Column
	private double price;
	@Column
	private String rating;
	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game(String name, String platform, double price, String rating) {
		super();
		this.name = name;
		this.platform = platform;
		this.price = price;
		this.rating = rating;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Game) {
			Game other = (Game) obj;
			boolean sameName = this.name.equals(other.getName());
			boolean samePlatform = this.platform.equals(other.getPlatform());
			//These will be used when web scraping is incorported
//			boolean samePrice = this.price == other.getPrice();
//			boolean sameRating = this.rating.equals(other.getRating());
			if(sameName && samePlatform /*&& samePrice && sameRating*/)
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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Game [name=" + name + ", platform=" + platform + ", price=" + price + ", rating=" + rating + "]";
	}
}
