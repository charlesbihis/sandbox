package com.charlesbihis.sandbox.findprimefactors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class FindPrimeFactors {
	public int[] findPrimeFactors(int n) {
		List<Integer> answer = new ArrayList<Integer>();
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				answer.add(i);
				n = n / i;
				i = 2;		// reset the loop
			}
		}
		answer.add(n);

		Collections.sort(answer);
		
		return ArrayUtils.toPrimitive(answer.toArray(new Integer[0]));
	}
}
