package com.movies.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.movies.entity.CustomerEntity;
import com.movies.entity.MovieEntity;
import com.movies.entity.RatingEntity;
import com.movies.model.Customer;
import com.movies.model.Movie;
import com.movies.model.Rating;

@Repository(value = "moviesDAO")
public class MoviesDAOImpl implements MoviesDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	/*
	 * @Override public int addMovieRating(Rating rating) {
	 * 
	 * RatingEntity ratingEntity = new RatingEntity();
	 * ratingEntity.setRating(rating.getRating()); Customer customer =
	 * rating.getCustomer(); System.out.println(rating.toString()
	 * +"//"+ratingEntity.toString()); CustomerEntity customerEntity = new
	 * CustomerEntity(); customerEntity.setFirstName(customer.getFirstName());
	 * customerEntity.setLastName(customer.getLastName());
	 * System.out.println(customer.toString()+"//"+customerEntity.toString()); Movie
	 * movie = customer.getMovie(); System.out.println(movie.toString());
	 * MovieEntity movieEntity = entityManager.find(MovieEntity.class,
	 * movie.getmId()); System.out.println(movieEntity.toString());
	 * if(movieEntity==null) { return -1; } customerEntity.setMovie(movieEntity);
	 * ratingEntity.setCustomer(customerEntity);
	 * entityManager.persist(ratingEntity); System.out.println("rating added "+
	 * ratingEntity.toString()); return ratingEntity.getrId(); }
	 */
	
	@Override
	public int addMovieRating(Rating rating) {
		
		MovieEntity movieEntity = entityManager.find(MovieEntity.class, 1);
		System.out.println(movieEntity);
		return 1;
	}
}
