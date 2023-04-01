import java.util.*;

public class Factorial {
	public static void main(String[] args) {
		int userNum = Integer.parseInt(args[0]);
		if (userNum < 0 || userNum > 20) {
			System.out.println("Error: the input number must be greater than zero and smaller than twenty.");
		} else {
			System.out.println("The factorial of " + userNum + " is " + calculate((long)userNum));
		} 
		long testOne = Factorial.calculate(0);
		if (testOne == 1) {
			System.out.println("Factorial.calculate(0) returned 1. Test passed!");
		} else {
			System.out.println("Factorial.calculate(0) returned " + testOne + ". Test failed");
		}
		long testTwo = Factorial.calculate(5);
		if (testTwo == 120) {
			System.out.println("Factorial.calculate(5) returned 120. Test passed!");
		} else {
			System.out.println("Factorial.calculate(5) returned " + testTwo + ". Test failed.");
		}
	}
	public static long calculate(long n) {
		if (n == 0) {
			return 1;
		} else {
			return (n * (calculate(n-1)));
		}
	}
}