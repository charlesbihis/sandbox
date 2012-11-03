package com.charlesbihis.sandbox.findprimefactors;

import junit.framework.TestCase;

import org.junit.Test;

public class FindPrimeFactorsTest extends TestCase {
	public void setUp() {
	}

	public void tearDown() {
	}

	@Test
	public void testFindPrimeFactorsBase() {
		int number = 0;
		int[] expected = {0};
		int[] actual = new FindPrimeFactors().findPrimeFactors(number);
		
		assertIntArrayEquals(expected, actual);
	}
	
	@Test
	public void testFindPrimeFactorsSmall() {
		int number = 6;
		int[] expected = {2, 3};
		int[] actual = new FindPrimeFactors().findPrimeFactors(number);
		
		assertIntArrayEquals(expected, actual);
	}
	
	@Test
	public void testFindPrimeFactorsMedium() {
		int number = 100;
		int[] expected = {2, 2, 5, 5};
		int[] actual = new FindPrimeFactors().findPrimeFactors(number);
		
		assertIntArrayEquals(expected, actual);
	}
	
	@Test
	public void testFindPrimeFactorsLarge() {
		int number = 958369039;
		int[] expected = {73, 13128343};
		int[] actual = new FindPrimeFactors().findPrimeFactors(number);
		
		assertIntArrayEquals(expected, actual);
	}
	
	private void assertIntArrayEquals(int[] expected, int[] actual) {
		assertEquals(expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
}
