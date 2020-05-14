package com.rate.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rate.movie.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
