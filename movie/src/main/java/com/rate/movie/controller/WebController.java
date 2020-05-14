package com.rate.movie.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rate.movie.model.Customer;
import com.rate.movie.model.Movie;
import com.rate.movie.model.Rating;
import com.rate.movie.repository.CustomerRepository;
import com.rate.movie.repository.MovieRepository;
import com.rate.movie.repository.RatingRepository;

@RestController
@RequestMapping("/api/rest")
public class WebController {
	
	    @Autowired
	    MovieRepository repositoryM;
	      
	    @Autowired
	    RatingRepository repositoryR;
	    
	    @Autowired
	    CustomerRepository repositoryC;
	      
	    @RequestMapping()
	    public String constructor() {                                		//will help you to choose data to enter easily
	    	int m = repositoryM.findAll().size();
    		int c = repositoryC.findAll().size();
			return "Total Movies: "+ m + "\n" + 
   				 "Total Customers: " + c + "\n\n";
		}
	     
	    
	    @RequestMapping("/customer/{cid}/movie/{mid}/rate/{rate}")          //give customer id, movie id, rating in float
	    public String addRating(@PathVariable("cid") int cid, @PathVariable("mid") int mid, @PathVariable("rate") float rate) {
	    	
	    	Optional<Customer> cust = repositoryC.findById(cid);      		//finding the customer to give rating
	    	Optional<Movie> movie = repositoryM.findById(mid);        		//finding movie to add rating
	    	
	    	if(!movie.isPresent() || !cust.isPresent()) {
	    		return "Movie/customer doesn't exist..!";
	    	}
	    	if(rate>5 || rate <1)
	    		return "rating should be between 1 to 5.. try again!";
	    	
	    	Rating r = new Rating(cust.get(), movie.get(), rate);
	    	repositoryR.save(r);
	    	return "Rating added Successfully...";    	
	    }
	    
	    
	    @RequestMapping("/highestrated")
	    public  String findHighestRatedMovie() {
	    	List<Rating> list = repositoryR.findAll();
	    	if(list.isEmpty()) {
	    		return "No Ratings till yet..";
	    	}
	    	 Map<Movie, Double> map = list.stream()           				//to get a map with movies and their average rating
	    				.collect(Collectors
	    				.groupingBy(Rating::getMovie,
	    				Collectors.averagingDouble(e -> e.getRate())));
	    				
	    	 String result = map.entrySet()                 				//to find the name of the movie (movie object as a key) having max in average 
	    					 .stream()
	    					 .max(Map.Entry.comparingByValue())
	    					 .get().getKey().getName();
	    	 
	    	return "Highest rated movie in average is:  "+ result;
	    }
	    
	    
	    @RequestMapping("/customerRatedTheHighest")
	    public  String findCustomerRatedTheHighest() {
	    	List<Rating> list = repositoryR.findAll();
	    	if(list.isEmpty()) {
	    		return "No Ratings till yet..";
	    	}
	    	 Map<Customer, Double> map = list.stream()           			//to get a map with customers and their average rating
	    				.collect(Collectors
	    				.groupingBy(Rating::getCustomer,
	    				Collectors.averagingDouble(e -> e.getRate())));
	    				
	    	 Entry<Customer, Double> ent = map.entrySet()                  //to find the name of the customer (customer object as a key) having max in average 
	    					 .stream()
	    					 .max(Map.Entry.comparingByValue())
	    					 .get();
	    	 
	    	 Double avg = map.values().stream()
	    			 .collect(Collectors.averagingDouble(e -> e));         //average of total ratings of customers
	
	    	return "{"+ ent.getKey().toString() 
	    			+ ", \"customerAverageRating\" =  " + ent.getValue()
	    			+ ", \"averageRating\" =  " + avg + "}";
	    }
	      
}
