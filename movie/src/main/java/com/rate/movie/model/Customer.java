package com.rate.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int c_id;
	
	@Column(name = "firstname")
	private String firstName;
	 
	@Column(name = "lastname")
	private String lastName;
	
	public Customer() {
	}
	
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getC_id() {
		return c_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
