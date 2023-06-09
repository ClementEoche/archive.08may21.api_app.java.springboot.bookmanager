package com.mds.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Book extends BaseEntity{
	
	@ManyToOne(targetEntity = User.class, optional = true)
	private User user;
		
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int nbPage;
	
	@Column(nullable = false)
	private double price;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbPage() {
		return nbPage;
	}

	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Book [user=" + user + ", name=" + name + ", nbPage=" + nbPage + ", price=" + price + "]";
	}
	
	

}
