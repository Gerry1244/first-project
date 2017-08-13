package com.example.demo.models;

	//added class
	public class Whisper {
		String firstattempt;
		
		public Whisper(String message) {
			firstattempt = message;
		}
			
		public String quiet() {
			return firstattempt.toLowerCase(); 
		}

		
		}
		

	


