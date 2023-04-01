import java.util.*;

public class FunctionTest {
	public static void main(String[] args) {
		System.out.println("The root of sin(x) that falls between 3 and 4 is approximately " + findRoot(3.0, 4.0, 0.00000001));
	}
	public static double findRoot(double a, double b, double epsilon) {
		double x = (a+b) / 2;
		double solution = 0;
		if (Math.abs(a - x) < epsilon) {
			return x;
		} else if (Math.signum(Math.sin(x)) == Math.signum(Math.sin(a))) {
			solution = findRoot(x, b, epsilon);
		} else {
			solution = findRoot(a, x, epsilon);
		}
		return solution;
	}
}