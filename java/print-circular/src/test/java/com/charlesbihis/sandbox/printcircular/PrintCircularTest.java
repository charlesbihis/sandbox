package com.charlesbihis.sandbox.printcircular;

import org.junit.Assert;
import org.junit.Test;

import com.charlesbihis.sandbox.printcircular.PrintCircular;

public class PrintCircularTest {
	@Test
	public void testThreeByFour() {
		String[][] array = {{"1", "2", "3"},
							{"4", "5", "6"},
							{"7", "8", "9"},
							{"10", "11", "12"}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("123691211107458", printCircular.printCircular(array));
	}
	
	@Test
	public void testFourByThree() {
		String[][] array = {{"1", "2", "3", "4"},
							{"5", "6", "7", "8"},
							{"9", "10", "11", "12"}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("123481211109567", printCircular.printCircular(array));
	}
	
	@Test
	public void testSmallSquare() {
		String[][] array = {{"1", "2", "3"},
							{"4", "5", "6"},
							{"7", "8", "9"}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("123698745", printCircular.printCircular(array));
	}
	
	@Test
	public void testLargeSquare() {
		String[][] array = {{"1", "2", "3", "4", "5", "6", "7", "8", "9"},
							{"11", "12", "13", "14", "15", "16", "17", "18", "19"},
							{"21", "22", "23", "24", "25", "26", "27", "28", "29"},
							{"31", "32", "33", "34", "35", "36", "37", "38", "39"},
							{"41", "42", "43", "44", "45", "46", "47", "48", "49"},
							{"51", "52", "53", "54", "55", "56", "57", "58", "59"},
							{"61", "62", "63", "64", "65", "66", "67", "68", "69"},
							{"71", "72", "73", "74", "75", "76", "77", "78", "79"},
							{"81", "82", "83", "84", "85", "86", "87", "88", "89"},
							{"91", "92", "93", "94", "95", "96", "97", "98", "99"}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("123456789192939495969798999989796959493929181716151413121111213141516171828384858687888878685848382726252423222232425262737475767777675747363534333343536465666656454444555", printCircular.printCircular(array));
	}
	
	@Test
	public void testNull() {
		String[][] array = null;
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("", printCircular.printCircular(array));
	}
	
	@Test
	public void testEmpty() {
		String[][] array = {{}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("", printCircular.printCircular(array));
	}
	
	@Test
	public void testNullAndEmpty() {
		String[][] array = {{},{""}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("", printCircular.printCircular(array));
	}
	
	@Test
	public void testSingleItem() {
		String[][] array = {{"1"}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("1", printCircular.printCircular(array));
	}
	
	@Test
	public void testNullInterspersed() {
		String[][] array = {{"1", "2", null},
							{"4", null, "6"},
							{"7", "8", null}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("126874", printCircular.printCircular(array));
	}
	
	@Test
	public void testEmptyInterspersed() {
		String[][] array = {{"1", "2", ""},
							{"4", "", "6"},
							{"7", "8", ""}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("126874", printCircular.printCircular(array));
	}
	
	@Test
	public void testNullAndEmptyInterspersed() {
		String[][] array = {{"1", null, "3"},
							{"4", "", "6"},
							{null, "8", ""}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("13684", printCircular.printCircular(array));
	}
	
	@Test
	public void testOneDimensionalHorizontal() {
		String[][] array = {{"1", "2", "3"}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("123", printCircular.printCircular(array));
	}
	
	@Test
	public void testOneDimensionalVertical() {
		String[][] array = {{"1"},
							{"2"},
							{"3"},
							{"4"}};
		
		PrintCircular printCircular = new PrintCircular();
		Assert.assertEquals("1234", printCircular.printCircular(array));
	}
}
