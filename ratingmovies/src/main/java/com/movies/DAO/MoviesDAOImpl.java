package com.movies.DAO;

import org.springframework.stereotype.Repository;

import com.movies.entity.Movie;
import com.movies.entity.Rating;

@Repository(value = "moviesDAO")
public class MoviesDAOImpl implements MoviesDAO {

	@Override
	public void addMovie(int id,float rate) {
		Movie m = new Movie();
		m.setFirstName("Jack");
		m.setLastName("Bauer");
		Rating r = new Rating();
		r.setRating(rate);
		Movie.ratings.add(r);
		
	}

}
