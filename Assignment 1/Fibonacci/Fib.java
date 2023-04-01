public class Fib {
	public static void main(String[] args) {
		int userNum = Integer.parseInt(args[0]);
		int output = 0;
		int numOne = 1;
		int numTwo = 1;
		int temp;
		for (int i = 3; i < userNum; i++) {
			temp = numOne + numTwo;
			numOne = numTwo;
			numTwo = temp;
		}
		if (userNum != 1 && userNum != 2) {
			output = numOne + numTwo;
			System.out.println(output);
		} else {
			System.out.println("1");
		}
	}
}