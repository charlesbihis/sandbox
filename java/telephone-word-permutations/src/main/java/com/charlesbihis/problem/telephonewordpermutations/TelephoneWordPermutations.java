package com.charlesbihis.problem.telephonewordpermutations;

/**
 * Class to iterate through all of the possible permutations
 * of letters of a given telephone number.
 * 
 * @author Charles Bihis (www.whoischarles.com)
 *
 */
public class TelephoneWordPermutations {
	public void printTelephoneWords(int[] phoneNumber) {
		doPrintTelephoneWords(phoneNumber, new char[phoneNumber.length], 0);
	}
	
	private void doPrintTelephoneWords(int[] phoneNumber, char[] phoneWord, int pos) {
		if (pos == phoneNumber.length) {
			System.out.println(phoneWord);
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			phoneWord[pos] = getLetterForNumber(phoneNumber[pos], i);
			doPrintTelephoneWords(phoneNumber, phoneWord, pos + 1);
			
			// Quit early for the special numbers 0 and 1 since we know
			// they don't have any letters assigned to them.
			if (phoneNumber[pos] == 0 || phoneNumber[pos] == 1) {
				return;
			}
		}
	}
	
	private char getLetterForNumber(int number, int place) {
		switch(number) {
			case 2:
				return "abc".charAt(place);
			case 3:
				return "def".charAt(place);
			case 4:
				return "ghi".charAt(place);
			case 5:
				return "jkl".charAt(place);
			case 6:
				return "mno".charAt(place);
			case 7:
				return "prs".charAt(place);
			case 8:
				return "tuv".charAt(place);
			case 9:
				return "wxy".charAt(place);
		}
		
		return Character.forDigit(number, 10);
	}
}
