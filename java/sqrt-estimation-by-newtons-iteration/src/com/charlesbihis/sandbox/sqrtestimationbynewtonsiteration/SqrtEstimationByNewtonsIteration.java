package com.charlesbihis.sandbox.sqrtestimationbynewtonsiteration;

public class SqrtEstimationByNewtonsIteration {
	public static final double DELTA = 1e-9;
	
	public static void main(String[] args) {
		System.out.println(sqrt(100));
	}
	
	public static double sqrt(double num) {
		double guess = 1;
		double previous = 0;

		while (Math.abs(guess - previous) > DELTA) {
			previous = guess;
			guess = (guess + (num / guess)) / 2;
		}
		
		return guess;
	}  // sqrt
}
