package com.movies.entity;

public class Rating {
	float rating;

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [rating=" + rating + "]";
	}
}
