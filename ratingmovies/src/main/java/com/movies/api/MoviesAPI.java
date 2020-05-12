package com.movies.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movies.entity.MovieEntity;
import com.movies.model.Rating;
import com.movies.service.MoviesService;

@RestController
@RequestMapping(value="/")
public class MoviesAPI {

	@Autowired
	MoviesService moviesService;
	
	@PostMapping("/addrating")
	public ResponseEntity<String> addCustomer(@RequestBody Rating rating) throws Exception  {
		int id = moviesService.addMovieRating(rating);
		String successMessage ="Rating added successfully for "+ id;
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		return response;
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String addCustomer() throws Exception  {
//		//ResponseEntity<String> response = new ResponseEntity<String>("I am UP!!", HttpStatus.OK);
//		return "hello";
//	}
}
