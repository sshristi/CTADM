package com.movies.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.entity.Movie;
import com.movies.service.MoviesService;

@RestController
@RequestMapping(value="/api/rest")
public class MoviesAPI {

	@Autowired
	MoviesService moviesService;
	@PostMapping("/customer/{Id}/rate/{rating}")
	public ResponseEntity<String> addCustomer(@PathVariable Integer id,@PathVariable Float rating) throws Exception  {
		moviesService.addMovie(id, rating);
		String successMessage = "Rating added successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		return response;
	}
}
