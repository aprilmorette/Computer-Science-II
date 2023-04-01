import java.util.*;
import java.lang.*;

public class FibTest {
	public static void main(String[] args) {
		// first test with 12 (output should be 144)
		int firstMethod = fibIter(12);
		int secondMethod = fibRecur(12);
		if (firstMethod == secondMethod) {
			System.out.println("Same output: 144, test one passed!");
		} else {
			System.out.println("Methods failed: fibIter output was " + fibIter(12) + " and fibRecur output was " + fibRecur(12));
		}
		// second test with 2 (output should be 1)
		int firstMethod2 = fibIter(2);
		int secondMethod2 = fibRecur(2);
		if (firstMethod2 == secondMethod2) {
			System.out.println("Same output: 1, test two passed!");
		} else {
			System.out.println("Methods failed: fibIter output was " + fibIter(2) + " and fibRucur output was " + fibRecur(2));
		}
		// third test for time elapsed
		long startTestOne = System.currentTimeMillis();
		FibTest.fibIter(40);
		long endTestOne = System.currentTimeMillis();
		System.out.println("Time it takes for the iterative method: " + (endTestOne - startTestOne) + " milliseconds.");
		long startTestTwo = System.currentTimeMillis();
		FibTest.fibRecur(40);
		long endTestTwo = System.currentTimeMillis();
		System.out.println("Time it takes for the recursive method: " + (endTestTwo - startTestTwo) + " milliseconds.");
	}
	public static int fibIter(int n) {
		int output = 0;
		int numOne = 1;
		int numTwo = 1;
		int temp;
		for (int i = 3; i < n; i++) {
			temp = numOne + numTwo;
			numOne = numTwo;
			numTwo = temp;
		}
		if (n != 1 && n != 2) {
			output = numOne + numTwo;
		} else {
			output = 1;
		}
		return output;
	}
	public static int fibRecur(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return (fibRecur(n-1)) + (fibRecur(n-2));
		}
	}
}