
import javax.swing.JOptionPane;

/**
 * Driver to estimate the limit of one of several functions 
 * as x goes to a specified value from the left
 * @author ralexander
 *
 */
public class EstimateLimit {

	private static Function fn;

	public static void main(String[] args) {
		//declare local variables
		int fnVersion = 0;
		double x = 0.0;
		String input;
		boolean again = false;
		//do loop that repeats if user wants to estimate another limit
		do {
			//displays the options and prompts the user to choose one
			//this should not be hardwired, but call the getDescription(i) methods of the Function class
			input = JOptionPane.showInputDialog(null,"This program estimates the limit of a function (from the left)\n"+
											 "The functions to choose from are:\n"+
				                             "    1. "+Function.getDescription(1)+"\n"+
				                             "    2. "+Function.getDescription(2)+"\n"+
				                             "    3. "+Function.getDescription(3)+"\n"+
				                             "    4. "+Function.getDescription(4)+"\n"+
				                             "    5. "+Function.getDescription(5)+"\n"+
							     "For which function do you want to estimate the limit? (1 - 5)");
			//parses the string into an integer. 
			//Does not catch a non-integer entry - will cause an unhandled exception
			fnVersion  = Integer.parseInt(input);
			
			//while loop to ensure choices are between 1 and 5
			while(fnVersion<1 || fnVersion>5) {
				input = JOptionPane.showInputDialog(null,"Input must be 1, 2, 3, 4, or 5. Try again\n");
				fnVersion  = Integer.parseInt(input);
			}
			
			//create the chosen function instance
			fn = new Function(fnVersion);
			
			//user enters the value that x goes to
			input = JOptionPane.showInputDialog(null,"As x goes to what value (from the left)?");
			//parses the string result into a double
			x = Double.parseDouble(input);
			//call the method to estimate the limit
			estimateLimit(x);
		
			//prompt the user to ask if he/she wants to estimate another limit
			String againString = JOptionPane.showInputDialog(null,"Do you want to try again? (y or n)");
			
			//if the user entered y, set the boolean again to true
			if (againString.equals("y")) {
				again=true;
			}
			//if the user entered anything except y, set the boolean again to false
			else {
				again=false;
				System.out.println("Goodbye");
			}
		}
		while(again);
		
	}
	
	/**
	 * the method estimateLimit computes the approximate value of the chosen function ten times, coming closer
	 * and closer to f(x) as x gets closer and closer to the desired value from the left
	 * @param functionChoice one of five integers that represents the five functions
	 * @param x the user's input to the limit of the function
	 */
	private static void estimateLimit(double x) {
		//false if the function diverges, true if the limit exists
		boolean limitExists = true;
		//whether or not the user wants to repeat the process
		boolean again=true;
		//to test if the function is diverging, we need to know the previous value of the function
		double previousResult=0;
		//the current value of the function
		double result=0;;
	
		System.out.println("Estimating the limit of "+fn+" as x goes to "+x+" from the left");
		//System.out.println("Estimating the limit of f"+fn.getFunctionChoice()+"(x) as x goes to "+x+" from the left");
		//back x off by 1.0 to approach limit from the left
		x--;
		//a for loop that will loop ten times, or until it is determined that the function is diverging
		for (int i=1; (i<10 && limitExists); i++) {
			//for each iteration of the for loop, calculate the value of the function with a closer and closer value of the input
			result = calcFunction(x+=(9/Math.pow(10,i)));
			//an if statement that tests if the previous result is more than 1.0 away from the current result
			//the if statement ensures that at least five iterations are done before testing for divergence
			if ((i > 5)&&Math.abs(previousResult-result)>1.0) {
				JOptionPane.showMessageDialog(null, "Diverging: estimate that limit of "+fn+" as x->"+(Math.round(x*100))/100.0+" does not exist");
				limitExists = false;
			}
			else {
				System.out.println("for x = "+x+", "+fn+" = "+result);
				previousResult = result;
			}
		}
		//an if statement that shows the estimated limit if the limit exists, rounded to two decimal places
		if (limitExists) {
			JOptionPane.showMessageDialog(null, "Estimate that the limit of "+fn+" as x->"+(Math.round(x*100))/100.0+" is "+(Math.round(result*100))/100.0);
		}		
	}

	/**
	 * calcFunction calls the appropriate function calculation
	 * @param functionChoice the function the user has selected
	 * @param x the current input to the function, getting closer and closer to the desired
	 *          value with each call to this function
	 * @return a double which is the value of the function at x
	 */
	private static double calcFunction(double x) {
		return fn.computeFunctionValue(x);
	}

}
