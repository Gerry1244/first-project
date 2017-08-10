package com.example.demo.models;

//added class
public class Yeller {
	String firstattempt;
	
	public Yeller(String message) {
		firstattempt = message;
	}
		
	public String makeupper() {
		return firstattempt.toUpperCase(); 
	}
	

}

