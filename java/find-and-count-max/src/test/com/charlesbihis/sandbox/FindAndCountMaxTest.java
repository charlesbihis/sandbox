package com.charlesbihis.sandbox;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.Test;

public class FindAndCountMaxTest extends TestCase {
	OutputStream outputStream = new ByteArrayOutputStream();
	
	public void setUp() {
		System.setOut(new PrintStream(outputStream));
	}

	public void tearDown() {
		System.setOut(System.out);
	}

	@Test
	public void testFindAndCountMaxSmall() {
		int[] intArray = {2, 5, 3, 2, 7, 4, 7, 2, 4};
		new FindAndCountMax().findAndCountMax(intArray);
		
		assertEquals("Max value is: 7\r\nIt occurs 2 times\r\n", outputStream.toString());
	}
	
	@Test
	public void testFindAndCountMaxMedium() {
		int[] intArray = {28, 53, 2, 59, 20, 41, 44, 60, 40, 22, 90, 92, 31, 23, 53, 62, 31, 53, 26, 7, 4, 32, 63, 53, 22, 75, 78, 2, 3, 6, 15, 35, 4, 7, 88, 93, 25, 4, 75, 8, 29, 11, 1, 53};
		new FindAndCountMax().findAndCountMax(intArray);
		
		assertEquals("Max value is: 93\r\nIt occurs 1 times\r\n", outputStream.toString());
	}
}
