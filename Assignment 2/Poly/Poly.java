import java.util.*;
import java.lang.*;

public class Poly {
	
	public static void main(String[] args) {
		int[] one = {2, 3, 0, -8, 0, 4}; 
		Poly polynomialOne = new Poly(one); // 2x^5 + 3x^4 - 8x^2 + 4
		System.out.println("Polynomial one: " + polynomialOne.toString());
		if (polynomialOne.degree() == 5) {
			System.out.println("\tThe degree of the polynomial is: " + polynomialOne.degree() + ". Test successful!");
		} else {
			System.out.println("\tThe degree of the polynomial is: " + polynomialOne.degree() + ". Test failed.");
		}
		if (polynomialOne.evaluate(2.0) == 84.0) {
			System.out.println("\tThe polynomial evaluated at x = 2.0: " + polynomialOne.evaluate(2.0) + ". Test successful!");
		} else {
			System.out.println("\tThe polynomial evaluated at x = 2.0: " + polynomialOne.evaluate(2.0) + ". Test failed.");
		}
		System.out.println("");
		int[] two = {8, -4, 0, 6};
		Poly polynomialTwo = new Poly(two); // 8x^3 - 4x^2 + 6
		System.out.println("Polynomial two: " + polynomialTwo.toString());
		if (polynomialTwo.degree() == 3) {
			System.out.println("\tThe degree of the polynomial is: " + polynomialTwo.degree() + ". Test successful!");
		} else {
			System.out.println("\tThe degree of the polynomial is: " + polynomialTwo.degree() + ". Test failed.");
		}
		if (polynomialTwo.evaluate(-1.5) == -30.0) {
			System.out.println("\tThe polynomial evaluated at x = -1.5: " + polynomialTwo.evaluate(-1.5) + ". Test successful!");
		} else {
			System.out.println("\tThe polynomial evaluated at x = -1.5: " + polynomialTwo.evaluate(-1.5) + ". Test failed.");
		}
		System.out.println("");
		System.out.println("The sum of both polynomials added together: " + polynomialOne.add(polynomialTwo).toString());
		// 2x^5 + 3x^4 + 8x^3 - 12x^2 + 10
	}
	
	private int[] coefficients;
	
	public Poly(int[] coefficients) {
		this.coefficients = new int[coefficients.length]; 
		for (int i = coefficients.length - 1; i >= 0; i--) {
			this.coefficients[i] = coefficients[i];
		}
	}
	public int degree() {
		int max = coefficients.length - 1;
		return max;
	}
	public String toString() {
		String printedPolynomial = "";
		for (int i = 0; i < coefficients.length; i++) {
			if (i != 0 && i != coefficients.length - 1 && coefficients[i] != 0) {   
				if (coefficients[i] > 0) { 
					printedPolynomial += " + " + Math.abs(coefficients[i]) + "x^" + (coefficients.length - i - 1);
				} else if (coefficients[i] < 0) {
					printedPolynomial += " - " + Math.abs(coefficients[i]) + "x^" + (coefficients.length - i - 1);
				}
			} else if (i == 0) {
				printedPolynomial += coefficients[i] + "x^" + (coefficients.length - i - 1);
			} else if (i == coefficients.length - 1) {
				printedPolynomial += " + " + Math.abs(coefficients[i]);
			}
		}
		return printedPolynomial;
	}
	public Poly add(Poly a) {
		int sum[];
		if (this.coefficients.length >= a.coefficients.length) {
			sum = new int[this.coefficients.length];
		} else {
			sum = new int[a.coefficients.length];
		} 
		for (int i = 0; i <= a.coefficients.length - 1;  i++) {
			sum[sum.length - a.coefficients.length + i] = a.coefficients[i];
		}
		for (int i = 0; i <= this.coefficients.length - 1; i++) {
			sum[sum.length - this.coefficients.length + i] += this.coefficients[i];
		} 
		Poly polynomialSum = new Poly(sum);
		return polynomialSum;
	}
	public double evaluate(double x) {
		double sum = 0;
		for (int i = 0; i < coefficients.length; i++) {
			sum += coefficients[i] * (Math.pow(x, coefficients.length - 1 - i));
		}
		return sum;
	}
}