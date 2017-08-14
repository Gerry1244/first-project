package com.example.demo.models.calculator;

public class Calculator {
	int numberone;
	double numbertwo;
	
	public Calculator(int first, double second) {
		numberone = first; 
		numbertwo = second;
	}
	
	public double adder() {
		double result = numberone + numbertwo;
		return result;
	}
  // Other methods go here !!
	public double subtractor() {
		double result = numberone - numbertwo;
		return result;
	}
	
	public double multiplier() {
		double result = numberone * numbertwo;
		return result;
	}
	
	public double divider() {
		double result = numberone / numbertwo;
		return result;
	}
	
	public double modulus() {
		double result = numberone % numbertwo;
		return result;
	}
	
	public double exponent() {
		double result = numberone % numbertwo;
		return result;
	}

}
	
