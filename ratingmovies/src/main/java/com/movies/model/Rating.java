package com.movies.model;

public class Rating {
	int rId;
	Customer customer;
	float rating;
	public Rating() {
		super();
		
	}
	public Rating(Customer customer, float rating) {
		super();
		this.customer = customer;
		this.rating = rating;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
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
