package com.charlesbihis.sandbox.quine;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import com.charlesbihis.sandbox.quine.Quine;


public class QuineTest extends TestCase {
	OutputStream outputStream = new ByteArrayOutputStream();

	public void setUp() {
		System.setOut(new PrintStream(outputStream));
	}

	public void tearDown() {
		System.setOut(System.out);
	}
	
	@Test
	public void testQuine() {
		Quine.main(null);
		Assert.assertEquals("package com.charlesbihis.sandbox.quine;\n\npublic class Quine {\n\tpublic static void main (String[] args) {\n\t\tString s = \"package com.charlesbihis.sandbox.quine;%3$c%3$cpublic class Quine {%3$c%4$cpublic static void main (String[] args) {%3$c%4$c%4$cString s = %2$c%1$s%2$c;%3$c%4$c%4$cSystem.out.printf(s, s, 34, 10, 9);%3$c%4$c}%3$c}\";\n\t\tSystem.out.printf(s, s, 34, 10, 9);\n\t}\n}", outputStream.toString());
	}
}
