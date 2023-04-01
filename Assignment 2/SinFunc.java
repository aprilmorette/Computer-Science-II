/** A class that is an extension of Function that changes the function to sin(x) */

public class SinFunc extends Function {
	
	/** Changes the function to be evaulated to sin(x).
		@param x The double being evaulated.
		@return the sin of x.
	*/
	
	public double evaluate(double x) {
			return Math.sin(x);
	}
}