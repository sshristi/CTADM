package com.rate.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "rating")
public class Rating {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  
	  @Column(name = "rate")
	  private float rate;
	  
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "c_id")
	  private Customer customer;
	  
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "m_id")
	  private Movie movie;
	  
	  protected Rating() {
	  }
	 
	  public Rating(Customer customer, Movie movie, float rate) {
		this.customer = customer;
		this.movie = movie;
	    this.rate = rate;
	  }
	 
	  @Override
	  public String toString() {
	    return String.format("Rating[id=%d, rate='%f']", id, rate);
	  }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
