package com.charlesbihis.sandbox;

public class FindAndCountMaxTwo {
	public void findAndCountMaxTwoVals(int[] nums) {
	    int max1 = Integer.MIN_VALUE;
	    int max2 = Integer.MIN_VALUE;
	    int max1Count = 0;
	    int max2Count = 0;

	    // die early
	    if (nums == null || nums.length == 0) {
	        System.out.println("Invalid input");
	        
	        return;
	    }

	    for (int i = 0; i < nums.length; i++) {
	        // check if num is new max1
	        if (nums[i] > max1) {
	            // demote first max to second max
	            max2 = max1;
	            max2Count = max1Count;
	        
	            max1 = nums[i];
	            max1Count = 0;
	        }
	        
	        // check if num is new max2
	        if (nums[i] > max2 && nums[i] < max1) {
	            max2 = nums[i];
	            max2Count = 0;
	        }
	        
	        // increment the max
	        if (nums[i] == max1) {
	            max1Count++;        
	        }
	        
	        // increment the second max {
	        if (nums[i] == max2) {
	            max2Count++;
	        }
	    }
	    
	    System.out.println("Max value is: " + max1);
	    System.out.println("It occurs " + max1Count + " times");
	    
	    System.out.println("Second max value is: " + max2);
	    System.out.println("It occurs " + max2Count + " times");
	}
}
