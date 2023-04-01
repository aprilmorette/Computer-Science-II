/** A class that is an extension of Function that changes the function to cos(x) */

public class CosFunc extends Function {
	
	/** Changes the function to be evaulated to cos(x).
		@param x The double being evaulated.
		@return the cos of x.
	*/
	
	public double evaluate(double x) {
		return Math.cos(x);
	}
}