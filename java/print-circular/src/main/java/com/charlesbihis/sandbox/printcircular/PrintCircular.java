package com.charlesbihis.sandbox.printcircular;

/**
 * Class to print the numbers in a 2-dimentional array in a circular sequence.
 * 
 * @author Charles Bihis (www.whoischarles.com)
 */
public class PrintCircular {
	
	private enum Direction {
		RIGHT, DOWN, LEFT, UP;
	}
	
	/**
	 * Method that takes a 2-dimensional array and prints the
	 * contents in a circular order.
	 * 
	 * Assumptions:
	 * 		For the sake of the exercise, I've assumed that the
	 * 		input array will contain Strings.  This can easily
	 * 		be changed to handle data types of any kind.  Also,
	 * 		to facilitate testing, I've changed the method from
	 * 		printing strings to returning them.  This way I can
	 * 		validate the string on return.
	 * 
	 * @param array The 2-dimensional array of which items to print
	 * @return A string containing the contents of the 2-dimensional array in circular order
	 */
	public String printCircular(String[][] array) {
		String result = "";
		
		// catch invalid input
		if (array == null || array.length == 0 || array[0].length == 0) {
			return result;
		}
		
		int level = 0;
		int index = 0;
		int count = 0;
		int[] bounds = new int[Direction.values().length];
		Direction direction = Direction.RIGHT;
		
		while(true) {
			// build our result string
			count++;
			if (array[level][index] != null) {
				result += array[level][index];
			}
			
			// know when to quit
			if (array[0].length * array.length == count) {
				break;
			}
			
			// depending on the direction, let's increment or decrement our level and index
			switch(direction) {
				case RIGHT:
					if (index + 1 < array[level].length - bounds[Direction.RIGHT.ordinal()]) {
						index++;
					} else {
						level++;
						bounds[Direction.UP.ordinal()]++;
						direction = Direction.DOWN;
					}
					break;
				case DOWN:
					if (level + 1 < array.length - bounds[Direction.DOWN.ordinal()]) {
						level++;
					} else {
						index--;
						bounds[Direction.RIGHT.ordinal()]++;
						direction = Direction.LEFT;
					}
					break;
				case LEFT:
					if (index - 1 >= bounds[Direction.LEFT.ordinal()]) {
						index--;
					} else {
						level--;
						bounds[Direction.DOWN.ordinal()]++;
						direction = Direction.UP;
					}
					break;
				case UP:
					if (level - 1 >= bounds[Direction.UP.ordinal()]) {
						level--;
					} else {
						index++;
						bounds[Direction.LEFT.ordinal()]++;
						direction = Direction.RIGHT;
					}
					break;
			}
		}
		
//		System.out.println(result);
		return result;
	}
}
