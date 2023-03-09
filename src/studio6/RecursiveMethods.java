package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			// FIXME compute the geometric sum for the first n terms recursively
		if (n==0) {
			return 0;
		}
		else {
			double sum = geometricSum(n-1) +(1/Math.pow(2, n));
			return sum;
		}
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		
			// FIXME compute the gcd of p and q using recursion
		if (p%q==0) {
			return q;
		}
		else {
			return gcd(q, p%q);
		}
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
			if (array.length == 0) {
				return new int [0];
			}
			else if(array.length == 1) {
				int [] array1 = new int [1];
				array1[0] = array[0];
				return array1;
			}
			else {
				return toReversedHelper (array,  new int [array.length], 0);
			}
			// FIXME create a helper method that can recursively reverse the given array
		
	}
	public static int[] toReversedHelper(int[] array, int[]reverseArray, int n) {
		if (n==array.length) {
			return reverseArray;
		}
		else {
			reverseArray[array.length-1-n] = array[n];
			return toReversedHelper(array,reverseArray, n+1);
		}
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		if (radius < radiusMinimumDrawingThreshold) {
			return;
		}
		else {
			StdDraw.pause(200);
			circlesUponCircles(xCenter+radius, yCenter, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter-radius, yCenter, radius/3, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter+radius, radius/3,radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter-radius, radius/3,radiusMinimumDrawingThreshold);
			StdDraw.circle(xCenter, yCenter, radius);
		}
		
	}
	public static void main(String[] args) {
		circlesUponCircles(0.5,0.5, 0.25, 0.01);
	}
}
