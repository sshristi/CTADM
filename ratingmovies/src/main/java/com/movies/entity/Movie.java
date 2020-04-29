package com.movies.entity;

import java.util.ArrayList;
import java.util.List;


public class Movie {
	public static List<Rating> ratings= new ArrayList<>();
	int id;
	String firstName;
	String lastName;
	Rating rate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Rating getRate() {
		return rate;
	}
	public void setRate(Rating rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", ratings=" + ratings + "]";
	}
	
}
