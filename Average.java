import java.util.Scanner;

public class Average {
	public static void main(String[] args) {
		double userNum;
		int count = 0;
		double average = 0;
		Scanner scnr = new Scanner(System.in);
		System.out.println("Please enter a series of numbers. Enter a negative number to quit.");
		do {
			userNum = scnr.nextDouble();
			if (userNum >= 0) {
				count++;
				average += userNum;
			} else {
				break;
			}
		} while (userNum >= 0);
		average = average / (double)count;
		System.out.println("You entered " + count + " numbers averaging " + average + ".\n");
	}
}