import java.text.NumberFormat;
/**
 * Abstract class Ticket
 * @author Yared Fikremariam
 *
 */
public abstract class Ticket {

	
	//protected enum Format {IMAX,THREE_D,NONE}
	protected String name,rating,fmt;
	protected int day,time,ID;
	protected Format ft;
	protected double price;
	protected NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	protected String type;
	protected final double TAX=0.096;
	
	/**
	 * no-arg constructor
	 */
	
	Ticket()
	{
		
	}
	
	/**
	 * parameterized constructor
	 * @param n name of the movie
	 * @param r rating of the movie
	 * @param d day
	 * @param t time
	 * @param f format
	 */
	Ticket(String n,String r,int d,int t,String f)
	{
		name=n;
		day=d;
		time=t;
		rating=r;
		fmt=f;
		
		
		
	}
	
	/**
	 * parameterized constructor
	 * @param n name of the movie
	 * @param r rating of the movie
	 * @param d day
	 * @param t time
	 * @param f format
	 */
	Ticket(String n,String r,int d,int t,String f,int iD)
	{
		name=n;
		day=d;
		time=t;
		rating=r;
		fmt=f;
		ID=iD;
	
		
	}
	/**
	 * Enumerated type for the format of the movie
	 * @author Yared
	 *
	 */
	protected enum Format 
	{
		IMAX
		{
			@Override
			public String toString()
			{
				return "IMAX";
			}
			
		},
		THREE_D
		{
			@Override
			public String toString()
			{
				return "3D";
			}
			
		},
		
		NONE
		{
			@Override
			public String toString()
			{
				return " ";
			}
		};
		
	}
	/**
	 * to String method to be overridden by sub classes later
	 */
	public String toString()
	{
		String str;
		
		
		
		str=ft.toString()+" "+"Movie:"+name+" "+"Rating:"+rating+" "+"Day: "+day+" Time: "+time;
		
		return str;
	}
	
	public abstract int getId();
	public abstract double calculateTicketPrice();
	
}
