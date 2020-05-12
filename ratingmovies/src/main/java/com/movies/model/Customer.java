package com.movies.model;

import java.util.List;

public class Customer {
	int cId;
	String firstName;
	String lastName;
	Movie movie;
	static List<Movie> moviesRated;
	
	public Customer(int cId, String firstName, String lastName, Movie movie) {
		this.cId = cId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.movie = movie;
	}
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
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
	public List<Movie> getMoviesRated() {
		return moviesRated;
	}
	public void setMoviesRated(List<Movie> moviesRated) {
		this.moviesRated = moviesRated;
	}
	
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", firstName=" + firstName + ", lastName=" + lastName + ", moviesRated="
				+ moviesRated + "]";
	} 	
}
