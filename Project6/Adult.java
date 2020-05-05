/**
 * Adult Class extends Ticket
 * @author Yared Fikremariam
 *
 */
public class Adult extends Ticket{
	
	private final double matinee=10.5;
	private final double evening=13.5;
	
	/**
	 * no-arg constructor
	 */
	
	Adult()
	{
		super();
		
	}
	/**
	 * parameterized constructor
	 * @param n name of the movie
	 * @param r rating
	 * @param d day
	 * @param t time
	 * @param f format
	 * @param iD id of the patron,0
	 */
	Adult(String n,String r,int d,int t,String f,int iD)
	{
		
		super(n,r,d,t,f,iD);
		price=calculateTicketPrice();
		type="ADULT";
		setFormat(f);
	}
	
	/**
	 * set name
	 * @param n
	 */
	public void setName(String n)
	{
		this.name=n;
	}
	/**
	 * get name
	 * @return
	 */
	public String getName()
	{
		
		return name;
	}
	/**
	 * set rating
	 * @param r
	 */
	public void setRating(String r)
	{
		this.rating=r;
		
	}
	
	/**
	 * get rating
	 * @return
	 */
	public  String getRating()
	{
		return rating;
		
	}
	
	/**
	 * set day
	 * @param d
	 */
	public void setDay(int d)
	{
		this.day=d;
	}
	/**
	 * get day
	 * @return
	 */
	public  int getDay()
	{
		return day;
	}
	/**
	 * set time
	 * @param t
	 */
	public void setTime(int t)
	{
		this.time=t;
		
	}
	/**
	 * get time
	 * @return
	 */
	public int getTime()
	{
		return time;
		
	}
	
	
	/**
	 * get id
	 */
	@Override
	public int getId()
	{
		
		return -1;
	}
	
	/**
	 * set the format of the movie
	 * @param f
	 */
	public  void setFormat(String f)
	{
		if(fmt.equals("3D"))
		{
			ft=Format.THREE_D;
			
		}
		else if(fmt.equals("IMAX"))
		{
			ft=Format.IMAX;
			
		}
		else if(fmt.equals("NONE"))
		{
			ft=Format.NONE;
			
		}
		
		
	
	}
	/**
	 * get format
	 * @return
	 */
	public String getFormat()
	{
		return fmt;
	}
	
	/**
	 * calculate the price of ticket
	 */
	@Override
	public double  calculateTicketPrice()
	{
		
		
		double price=0;
		if(time<18)
		{
			if(fmt.equals("3D"))
			{
				price=(matinee+2.5)+((matinee+2.5)*TAX); 
				
			}
			else if(fmt.equals("IMAX"))
			{
				price=(matinee+3.0)+((matinee+3.0)*TAX); 
				
			}
			
			else
				price=matinee+(matinee*TAX); 
			
		}
		
		if(time>=18)
		{

			if(fmt.equals("3D"))
			{
				price=(evening+2.5)+((evening+2.5)*TAX); 
				
			}
			else if(fmt.equals("IMAX"))
			{
				price=(evening+3.0)+((evening+3.0)*TAX); 
				
			}
			else 
				price=(evening)+(evening*TAX); 
		}
		
		
		return price;
	}
	
	
	/**
	 * to String method
	 */
	@Override
	public String toString()
	{
		
		String str;
		str=type+" "+super.toString()+" Price: "+currencyFormat.format(calculateTicketPrice());
		return str;
		
	}
}
