package com.rate.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rate.movie.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
