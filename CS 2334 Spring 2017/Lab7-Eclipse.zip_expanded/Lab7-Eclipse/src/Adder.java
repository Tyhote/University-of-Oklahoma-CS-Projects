/**
 * Lab 7, CS 2334, Section 010, 11 April 2017 
 * <P>
 * This class implements a method to add all the integers in an array
 * of integers.
 * </P>
 * 
 * @version 1.0
 */
public class Adder {

	/**
	 * This is a recursive function designed to add all the elements of
	 * an array from the index left, to the index right, including both.
	 * 
	 * Note: For such a simple algorithm as this, one would prefer an iterative
	 * version, instead of a recursive one.
	 * 
	 * @param array    The array of integers.
	 * @param left     The left  end of the sub-array whose elements we are adding.
	 * @param right    The right end of the sub-array whose elements we are adding.
	 * @param accum    An accumulator for the partial sum calculated so far.
	 * @return
	 */
	public static int recursiveSum(int[] array, int left, int right, int accum) {
		
		// Base Case: Array[left,...,right] is empty
		if( right < left || left < 0) {
			return accum;
		}
		else {
			// Recursive case:
			return recursiveSum( array, left + 1, right, array[left] + accum);
		}
	}
}