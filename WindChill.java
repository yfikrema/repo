import java.util.Scanner;

public class WindChill
{

	public static void main(String[] args) 
	{
		
		double temp;
		double speed;
		double WndChl;
		
		System.out.println("Wind Chill Calculator \n");
		System.out.println("Please enter temperature, must be between -45 and 40:");
		Scanner keyboard = new Scanner(System.in); 
	    temp = keyboard.nextDouble();
		
		
		while(temp<-45||temp>40)
		 
		{
			
			
			System.out.println("Temprature must be between -45 and 40,try again");
		    temp = keyboard.nextDouble();
			
			
		}
	
		
		
		System.out.println("Please enter speed, must be between 5 and 60:");
	    speed = keyboard.nextDouble();
		
		
		
	    while(speed<5||speed>60)
		 
	    {
	    	System.out.println("Speed must be between 5 and 60,try again");
		    speed = keyboard.nextDouble();
		   
			
		 }
		
		
			WndChl= 35.74+0.6215*temp-35.75*(Math.pow(speed,0.16))+0.4275*temp*(Math.pow(speed, 0.16));
			System.out.println("\nWind chill temperature is: "+ WndChl+ " degrees Fahrenheit");
		    System.out.println("\nProgrammer: Yared Fikremariam");
		    System.exit(0);
	
		
		}

}
