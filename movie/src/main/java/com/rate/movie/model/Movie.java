package com.rate.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int m_id;
	
	@Column(name = "name")
	String name;
	
	@Override
	public String toString() {
		return "Movie [m_id=" + m_id + ", name=" + name + "]";
	}

	public Movie(){
    }
    
    public Movie(String name){
    	this.name = name;
    }

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
