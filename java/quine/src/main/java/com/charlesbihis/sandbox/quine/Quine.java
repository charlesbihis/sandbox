package com.charlesbihis.sandbox.quine;

public class Quine {
	public static void main(String[] args) {
		String s = "package com.charlesbihis.sandbox.quine;%3$c%3$cpublic class Quine {%3$c%4$cpublic static void main (String[] args) {%3$c%4$c%4$cString s = %2$c%1$s%2$c;%3$c%4$c%4$cSystem.out.printf(s, s, 34, 10, 9);%3$c%4$c}%3$c}";
		System.out.printf(s, s, 34, 10, 9);
	}
}