package com.charlesbihis.sandbox.combinationsofastring;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class CombinationsOfAStringTest extends TestCase {
	OutputStream outputStream = new ByteArrayOutputStream();

	public void setUp() {
		System.setOut(new PrintStream(outputStream));
	}

	public void tearDown() {
		System.setOut(System.out);
	}
	
	@Test
	public void testSmallCombinationString() {
		new CombinationsOfAString().combine("wxyz");
		Assert.assertEquals("w\r\nwx\r\nwxy\r\nwxyz\r\nwxz\r\nwy\r\nwyz\r\nwz\r\nx\r\nxy\r\nxyz\r\nxz\r\ny\r\nyz\r\nz\r\n", outputStream.toString());
	}
}
