package com.charlesbihis.problem.sqrtestimationbybinarysearch;

/**
 * Class to implement sqrt() by estimation using a
 * binary search to find the square to a delta of 1e-9.
 * 
 * @author Charles Bihis (www.whoischarles.com)
 */
public class SqrtEstimationByBinarySearch {
	public static final double DELTA = 1e-9;
	
	public static double sqrt(double num) {
		double low = 0;
		double high = num;
		double mid = 0;
		
		while (low < high) {
			mid = (high + low) / 2;
			
			double result = mid * mid;
			if (Math.abs(result - num) < DELTA) {
				break;
			} else if (result < num) {
				low = mid;
			} else {
				high = mid;
			}  // if-else statement
		}  // while loop
		
		return mid;
	}  // sqrt
}  // class declaration
