package com.movies.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class MovieEntity {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	int mId;
	String name;
	
	public MovieEntity(int mId, String name) {
		super();
		this.mId = mId;
		this.name = name;
	}
	public MovieEntity() {
		super();
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	
	@Override
	public String toString() {
		return "Movie [mId=" + mId + ", name=" + name + "]";
	}
	
	
	
}
