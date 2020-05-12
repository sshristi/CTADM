package com.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.DAO.MoviesDAO;
import com.movies.model.Rating;

@Service(value = "moviesService")
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	MoviesDAO moviesDAO;
	
	@Override
	public int addMovieRating(Rating rating) throws Exception {

		int id = moviesDAO.addMovieRating(rating);
		if(id==-1) {
			throw new Exception("Service.MOVIE_UNAVAILABLE");
		}
		return id;
	}
	
}
