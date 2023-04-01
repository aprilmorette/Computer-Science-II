import java.util.*;
import java.lang.*;

/** A class that is an extension of Function that changes the function to a polynomial */

public class PolyFunc extends Function {
	
	public static void main(String[] args) {
	}
	
	private int[] coefficients;
	
	/** Constructor to create a PolyFunc object.
		@param coefficients An array of integers representing the polynomial's coefficients.
		@return 
	*/
	
	public PolyFunc(int[] coefficients) {
		this.coefficients = new int[coefficients.length]; 
		for (int i = coefficients.length - 1; i >= 0; i--) {
			this.coefficients[i] = coefficients[i];
		}
	}
	
	/** Changes the function to be evaulated to a polynomial.
		@param x The double being evaulated.
		@return the polynomial evaluated with the given x.
	*/
	
	public double evaluate(double x) {
		double sum = 0;
		for (int i = 0; i < coefficients.length; i++) {
			sum += coefficients[i] * (Math.pow(x, coefficients.length - 1 - i));
		}
		return sum;
	}
}