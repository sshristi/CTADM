package com.rate.movie.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rate.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
