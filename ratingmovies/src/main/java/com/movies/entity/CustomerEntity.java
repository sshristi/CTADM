package com.movies.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cId;
	@Column(name ="fname")
	String firstName;
	@Column(name ="lname")
	String lastName;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="mId")
	MovieEntity movie;
	
	public CustomerEntity() {
		super();
	}
	public MovieEntity getMovie() {
		return movie;
	}
	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}
	public CustomerEntity(int cId, String firstName, String lastName) {
		super();
		this.cId = cId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	} 	
}
