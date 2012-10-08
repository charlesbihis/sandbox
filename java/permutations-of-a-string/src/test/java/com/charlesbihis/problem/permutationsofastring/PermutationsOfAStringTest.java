package com.charlesbihis.problem.permutationsofastring;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import com.charlesbihis.problem.permutationsofastring.PermutationsOfAString;


public class PermutationsOfAStringTest extends TestCase {
	OutputStream outputStream = new ByteArrayOutputStream();

	public void setUp() {
		System.setOut(new PrintStream(outputStream));
	}

	public void tearDown() {
		System.setOut(System.out);
	}
	
	@Test
	public void testSmallPermutationString() {
		new PermutationsOfAString().permute("abcd");
		Assert.assertEquals("abcd\r\nabdc\r\nacbd\r\nacdb\r\nadbc\r\nadcb\r\nbacd\r\nbadc\r\nbcad\r\nbcda\r\nbdac\r\nbdca\r\ncabd\r\ncadb\r\ncbad\r\ncbda\r\ncdab\r\ncdba\r\ndabc\r\ndacb\r\ndbac\r\ndbca\r\ndcab\r\ndcba\r\n", outputStream.toString());
	}
}
