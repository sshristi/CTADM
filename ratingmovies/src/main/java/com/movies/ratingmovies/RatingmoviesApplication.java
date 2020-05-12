package com.movies.ratingmovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.movies.api.MoviesAPI;

@SpringBootApplication
@ComponentScan(basePackages = "com.movies")
public class RatingmoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingmoviesApplication.class, args);
	}

}
