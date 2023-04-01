import java.lang.Math;

public class Ramanujan {
	public static void main(String[] args) {
		int userNum = Integer.parseInt(args[0]);
		double ramanujanOutput = 0;
		for (int i = 0; i <= userNum; i++) {
			ramanujanOutput += (((Factorial.calculate(4*i))*(1103+(26390*i))) / (Math.pow(Factorial.calculate(i), 4)*(Math.pow(396, 4*i))));
		}
		
		 ramanujanOutput *= ((2*Math.sqrt(2)) / 9801);
		 ramanujanOutput = 1/ramanujanOutput;
		 System.out.println("Pi according to Ramanujan series: " + ramanujanOutput);
		 double percentError = (Math.abs(ramanujanOutput - Math.PI) / (Math.PI)) * 100.0;
		 System.out.println("This differs from Java's value by " + percentError + " percent.");
	}
}