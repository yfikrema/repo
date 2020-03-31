
/**
 * The purpose of this class is to run the driver class EstimateLimit
 * @author Yared Fikremariam 03/30/2020
 *
 */
public class Function {
	
	
    /**

     * The choice to compute function value

     */
	private double FUNCTION_CHOICE;
	
	
	
	/**
	 * description of the function
	 */
	
	private String descripton;
	
	
	 Function(int fnChoice)
	{
		FUNCTION_CHOICE=(double)fnChoice;
		setDescription();
		
		
	}
	
	 /**
	  * sets the description of the function
	  */
	public void setDescription()
	{
		
		 if(FUNCTION_CHOICE ==1.0)

			 descripton="(8x-sqrt(x))/(x^3-7x^2+15x-9)";

         else if (FUNCTION_CHOICE ==2.0)

        	 descripton="sin(x)";

         else if (FUNCTION_CHOICE ==3.0)

        	 descripton="(5/x)+35";

         else if (FUNCTION_CHOICE ==4.0)

        	 descripton="(sqrt(x^3+16)-4)/(x^2)";

         else if (FUNCTION_CHOICE == 5.0)

        	 descripton="(e^x-1)/x";
			
		
	}
	
	
	/**
	 * returns the function choice
	 * @param fnChoice
	 * @return
	 */
	
	public int getFunctionChoice(int fnChoice)
	{
		
		
		return (int)FUNCTION_CHOICE;
		
	}
	
	
	/**
	 * return the description of the function
	 * @param fnChoice
	 * @return
	 */
	public  static String getDescription(int fnChoice)
	
	{
		  
		  if(fnChoice ==1)

              return "(8x-sqrt(x))/(x^3-7x^2+15x-9)";

          else if (fnChoice ==2)

              return "sin(x)";

          else if (fnChoice ==3)

              return "(5/x)+35";

          else if (fnChoice ==4)

              return "(sqrt(x^3+16)-4)/(x^2)";

          else if (fnChoice == 5)

              return "(e^x-1)/x";

          else

              return "";
		
	}
	
	/**
	 * returns the description in String format
	 */
	public String toString()
	{
		
		 return  descripton +" for "+FUNCTION_CHOICE;
		
	}
	
	/**
	 * Calculates and returns the function value
	 * @param x
	 * @return
	 */
	
    public double computeFunctionValue( double x){

        if(FUNCTION_CHOICE==1.0)

        return (8*x-Math.sqrt(x))/(Math.pow(x,3)-7*Math.pow(x,2)+15*x-9);

        else if (FUNCTION_CHOICE ==2.0)

            return Math.sin(x);

        else if (FUNCTION_CHOICE ==3.0)

            return (5/x)+35;

        else if (FUNCTION_CHOICE ==4.0)

            return (Math.sqrt(Math.pow(x,3)+16)-4)/Math.pow(x,2);

        else if (FUNCTION_CHOICE == 5.0)

            return (Math.pow(Math.E,x)-1)/x;

        else

            return 0.0;

   }
	

}
