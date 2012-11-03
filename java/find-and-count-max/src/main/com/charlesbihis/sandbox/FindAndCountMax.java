package com.charlesbihis.sandbox;

public class FindAndCountMax {
	public void findAndCountMax(int[] nums) {
	    int max = Integer.MIN_VALUE;
	    int maxCount = 0;

	    // die early
	    if (nums == null || nums.length == 0) {
	        System.out.println("Invalid input");
	        
	        return;
	    }

	    for (int i = 0; i < nums.length; i++) {
	        // check if num is new max
	        if (nums[i] > max) {
	            max = nums[i];
	            maxCount = 0;
	        }
	        
	        // increment only the max
	        if (nums[i] == max) {
	            maxCount++;        
	        }
	    }
	    
	    System.out.println("Max value is: " + max);
	    System.out.println("It occurs " + maxCount + " times");
	}
}
