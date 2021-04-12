/**
 * 
 */
package readability;

import java.io.IOException;

/**
 * @author MohammadMagdy
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ExecutionFlow execute = new ExecutionFlow();
		execute.run("./src/readability/test.txt");
		
	}

}
