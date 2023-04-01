import java.lang.Math;

public class Gregory {
	public static void main(String[] args) {
		int userNum = Integer.parseInt(args[0]);
		double gregoryOutput = 0;
		for (double i = 1; i <= userNum; i++) {
			gregoryOutput += (Math.pow(-1, i + 1)) / ((2 * i) - 1);
		}
		 gregoryOutput *= 4.0;
		 System.out.println("Pi according to Gregory series: " + gregoryOutput);
		 double percentError = (Math.abs(gregoryOutput - Math.PI) / (Math.PI)) * 100;
		 System.out.println("This differs from Java's value by " + percentError + " percent.");
	}
}