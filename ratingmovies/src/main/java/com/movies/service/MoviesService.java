package com.movies.service;

import com.movies.model.Rating;

public interface MoviesService {
	int addMovieRating(Rating rating) throws Exception;
}
