package com.charlesbihis.problem.permutationsofastring;

import java.util.BitSet;

/**
 * Class to implement function that generates and prints all permutations
 * of the characters in a given string.
 * 
 * Given a string of length, n, this will produce n! permutations.  For
 * example, given a base string of "hat", the different permutations are
 * "tha", "aht", "tah", "ath", "hta", and "hat".  Given the string "aaa", then
 * simply "aaa" will be printed six times.  This is because in permutations,
 * order matters (as opposed to combinations, where order does NOT matter)!
 * 
 * @author Charles Bihis (www.whoischarles.com)
 */
public class PermutationsOfAString {
	/**
	 * Will generate and print all possible permutations of the
	 * characters of the given string.
	 * 
	 * @param string the base string for which to generate permutations
	 */
	public void permute(String string) {
		doPermute(string, new StringBuilder(), 0, new BitSet(string.length()));
	}  // permute

	/**
	 * Helper function for permute().
	 * 
	 * @param string	the base string for which to generate permutations
	 * @param perm		the current permutation
	 * @param pos		the position in the base string that we are at
	 * @param used		a bitset to indicate which values in the base string have been used already in our current permutation
	 */
	private void doPermute(String string, StringBuilder perm, int pos, BitSet used) {
		if (perm.length() == string.length()) {
			System.out.println(perm);
		}  // if statement

		for (int i = 0; i < string.length(); i++) {
			if (used.get(i)) {
				continue;
			}  // if statement

			perm.append(string.charAt(i));
			used.set(i);
			doPermute(string, perm, pos + 1, used);
			used.clear(i);
			perm.setLength(perm.length() - 1);
		}  // for loop
	}  // doPermute
}  // class declaration
