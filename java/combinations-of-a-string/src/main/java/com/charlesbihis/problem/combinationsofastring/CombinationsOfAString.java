package com.charlesbihis.problem.combinationsofastring;

/**
 * Class to implement function that generates and prints all combinations
 * of the characters in a given string.
 * 
 * The combinations can range in length from one to the length of the given
 * string.  Combinations are different from permutations in that order
 * does NOT matter.  In other words, "12" and "31" are different combinations
 * from the input string "123", but "12" and "21" are the same.
 * 
 * @author Charles Bihis (www.whoischarles.com)
 */
public class CombinationsOfAString {
	/**
	 * Will generate and print all possible combinations of the
	 * characters of the given string.
	 * 
	 * @param string the base string for which to generate combinations
	 */
	public void combine(String string) {
		doCombine(string, new StringBuilder(), 0);
	}  // combine
	
	/**
	 * Helper function for combine().
	 * 
	 * @param string	the base string for which to generate combinations
	 * @param comb		the current combination
	 * @param start		the current position in the base string for which to start appending new characters
	 */
	private void doCombine(String string, StringBuilder comb, int start) {
		for (int i = start; i < string.length(); i++) {
			comb.append(string.charAt(i));
			System.out.println(comb);
			
			if (i < string.length() - 1) {
				doCombine(string, comb, i + 1);
			}  // if statement
			
			comb.setLength(comb.length() - 1);
		}  // for loop
	}  // doCombine
}  // class declaration
