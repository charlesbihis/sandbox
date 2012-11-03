package com.charlesbihis.sandbox.sqrtestimationbybinarysearch;

import junit.framework.Assert;

import org.junit.Test;

import com.charlesbihis.sandbox.sqrtestimationbybinarysearch.SqrtEstimationByBinarySearch;

public class SqrtEstimationByBinarySearchTest {
	@Test
	public void testPerfectSquareOfFour() {
		Assert.assertEquals(2.0, SqrtEstimationByBinarySearch.sqrt(4));
	}
	
	@Test
	public void testPerfectSquareOfSixteen() {
		Assert.assertEquals(4.0, SqrtEstimationByBinarySearch.sqrt(16));
	}
	
	@Test
	public void testSquareOfTen() {
		Assert.assertTrue((SqrtEstimationByBinarySearch.sqrt(10) * SqrtEstimationByBinarySearch.sqrt(10) - SqrtEstimationByBinarySearch.DELTA) > 0);
	}
	
	@Test
	public void testSquareOfTwoHundred() {
		Assert.assertTrue((SqrtEstimationByBinarySearch.sqrt(200) * SqrtEstimationByBinarySearch.sqrt(200) - SqrtEstimationByBinarySearch.DELTA) > 0);
	}
}
