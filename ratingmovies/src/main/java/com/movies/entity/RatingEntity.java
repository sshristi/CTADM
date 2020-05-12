package com.movies.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.movies.model.Customer;
import com.movies.model.Movie;

@Entity
@Table(name = "rating")
public class RatingEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int rId;
	float rating;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cId")
	CustomerEntity customer;
	
	public RatingEntity() {
		super();
	}
	public RatingEntity(float rating) {
		super();
		this.rating = rating;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Rating [customer=" + customer + ", rating=" + rating + "]";
	}
}