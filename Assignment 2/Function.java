import java.util.*;
import java.lang.*;

/** Finds the roots of different types of functions */

public abstract class Function {
	
	/** Creates four objects that are hard coded functions.
		@param String[] args Not used since the functions are hard coded.
		@return Prints a string identifying the function and what the root is.
	*/
	
	public static void main(String[] args) {
		SinFunc funcOne = new SinFunc();
		System.out.println("The root of sin(x) between 3 and 4: " + funcOne.findRoot(3, 4, 0.00000001));
		CosFunc funcTwo = new CosFunc();
		System.out.println("The root of cos(x) between 1 and 3: " + funcTwo.findRoot(1, 3, 0.00000001));
		int[] arr1 = {1, 0, -3};
		PolyFunc funcThree = new PolyFunc(arr1);
		System.out.println("The positive root of x^2 - 3: " + funcThree.findRoot(0, 10, 0.00000001));
		int[] arr2 = {1, -1, -2};
		PolyFunc funcFour = new PolyFunc(arr2);
		System.out.println("The positive root of x^2 - x - 2: " + funcFour.findRoot(0, 10, 0.00000001));
	}
	
	/** Abstract method to use for the different extended classes (SinFunc, CosFunc, and PolyFunc)
		@param x The double being evaulated.
		@return 
	*/
	
	public abstract double evaluate(double x);
	
	/** Method to find the root of the function.
		@param a, b, epsilon All doubles: a and b are the constraints, episilon is the amount of error we are willing to tolerate.
		@return The root that is between a and b for the given function.
	*/
	public double findRoot(double a, double b, double epsilon) {
		double x = (a+b) / 2;
		double solution = 0;
		if (Math.abs(a - x) < epsilon) {
			return x;
		} else if (Math.signum(evaluate(x)) == Math.signum(evaluate(a))) {
			solution = findRoot(x, b, epsilon);
		} else {
			solution = findRoot(a, x, epsilon);
		}
		return solution;
	}
}