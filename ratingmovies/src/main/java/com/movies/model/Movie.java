package com.movies.model;

import java.util.List;

public class Movie {
	int mId;
	String name;
	
	public Movie(int mId, String name) {
		super();
		this.mId = mId;
		this.name = name;
	}
	public Movie() {
		
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
