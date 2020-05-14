package com.rate.movie.controller;


import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
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
	      
	    @RequestMapping("/")
	    public String constructor() {
	    	int m = repositoryM.findAll().size();
    		int c = repositoryC.findAll().size();
			return "Total Movies: "+ m + "\n" + 
   				 "Total Customers: " + c + "\n\n"
   				 ;
		}
	     
	    
	    @RequestMapping("/customer/{cid}/movie/{mid}/rate/{rate}")
	    public String addRating(@PathVariable("cid") int cid, @PathVariable("mid") int mid, @PathVariable("rate") float rate) {
	    	String result="";
	    	
	    	Optional<Customer> cust = repositoryC.findById(cid);
	    	
	    	Optional<Movie> movie = repositoryM.findById(mid);
	    	
	    	if(!movie.isPresent() || !cust.isPresent()) {
	    		return "Movie/customer doesn't exist..!";
	    	}else {
	    		if(rate>5 || rate <1)
	    			return "rating should be between 1 to 5.. try again!";
	    		Rating r = new Rating(cust.get(), movie.get(), rate);
	    		repositoryR.save(r);
	    		if(cust.get().getRatings()==null) {
	    			Set<Rating> set = new HashSet<Rating>();
	    			set.add(r);
	    			cust.get().setRatings(set);
	    		}
	    		cust.get().getRatings().add(r);
	    		if(movie.get().getRatings()==null) {
	    			Set<Rating> set = new HashSet<Rating>();
	    			set.add(r);
	    			movie.get().setRatings(set);
	    		}
	    		movie.get().getRatings().add(r);
	    		
	    		result = "Rating added Successfully...";
	    	}
	    	return result;
	    }
	    
	    @RequestMapping("/highestrated")
	    public  String findHighestRatedMovie() {
	    	List<Rating> list = repositoryR.findAll();
	    	if(list.isEmpty()) {
	    		return "No Ratings till yet..";
	    	}
	    	 Entry<Movie, Long> ent = list.stream()
	    				.collect(Collectors.groupingBy(Rating::getMovie,Collectors.counting()))
	    				.entrySet()
	    				.stream()
	    				.max(Map.Entry.comparingByValue()).get();
	    	return ent.getKey().getName();
	    }
	    
	    @RequestMapping("/findbyid/{id}")
	    public String findById(@PathVariable("id") int id){
	        String result = "";
	        result = repositoryM.findById(id).toString();
	        return result;
	    }
	      
	    /*
		 * @RequestMapping("/findall") public String findAll(){ String result =
		 * "<html>";
		 * 
		 * for(Movie movie : repositoryM.findAll()){ result += "<div>" +
		 * movie.toString() + "</div>"; }
		 * 
		 * return result + "</html>"; }
		 */
	    /*@RequestMapping("/findbylastname")
	    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
	        String result = "<html>";
	          
	        for(Customer cust: repository.findByLastName(lastName)){
	            result += "<div>" + cust.toString() + "</div>"; 
	        }
	          
	        return result + "</html>";
	    }*/
	
}
