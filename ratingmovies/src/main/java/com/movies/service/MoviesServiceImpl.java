package com.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.DAO.MoviesDAO;

@Service(value = "moviesService")
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	MoviesDAO movieDAO;
	
	@Override
	public void addMovie(int id,float rate) {
		
		movieDAO.addMovie(id, rate);
	}
	
}
