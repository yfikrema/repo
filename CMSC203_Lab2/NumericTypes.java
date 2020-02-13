import java.util.Scanner;
public class NumericTypes {

	public static void main(String[] args) {
		
		
		//TASK #2 Create a Scanner object here 
	Scanner	key = new Scanner(System.in);
				//identifier declarations
				final int NUMBER = 2; // number of scores
				//int score1 = 100; // first test score
				//int score2 = 95; // second test score
				//final int BOILING_IN_F = 212; // boiling temperature
				double fToC; // temperature in Celsius
				double average; // arithmetic average
				String output; // line of output to print out
				System.out.println("Enter Temperature");//Task #2 prompt user to input score1
				int temp = key.nextInt();//Task #2 declare a variable to hold the user’s temperature
				System.out.println("Enter Score1");//Task #2 prompt user to input score1
				int score1 = key.nextInt();//Task #2 read score1 
				System.out.println("Enter Score2");//Task #2 prompt user to input score2
				int score2 = key.nextInt();//Task #2 read score2 
				// Find an arithmetic average
				average = (score1 + score2) / NUMBER;
				output = score1 + " and " + score2 + " have an average of " + average;	
				System.out.println(output);
				// Convert Fahrenheit temperatures to Celsius
				fToC = (temp - 32)*5/9  ;
				output = temp + " in Fahrenheit is " + fToC + " in Celsius.";
				System.out.println(output);
				//Task #2 prompt user to input another temperature
				//Task #2 read the user’s temperature in Fahrenheit
				//Task #2 convert the user’s temperature to Celsius
				//Task #2 print the user’s temperature in Celsius
				System.out.println("Goodbye"); // to show that the program is ended		
		
		
	}

}
