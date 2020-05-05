/**
 * MoviePass Class
 * @author Yared Fikramariam
 *
 */

public class MoviePass extends Ticket{
	
	private final double matinee=10.5;
	private final double evening=13.5;
	MovieTicketManager w=new MovieTicketManager();
	
	/**
	 * Constructor
	 */
	MoviePass()
	{
		super();
		
	}
	/**
	 * Constructor with parameters
	 * @param n name of movie
	 * @param r
	 * @param d
	 * @param t
	 * @param f
	 * @param iD
	 */
	MoviePass(String n,String r,int d,int t,String f,int iD)
	{
		
		super(n,r,d,t,f,iD);
		price=calculateTicketPrice();
		type="MOVIEPASS";
		
		
		setFormat(f);
		
		
	}
	
	/**
	 * Set name
	 * @param n name of movie
	 */
	public void setName(String n)
	{
		this.name=n;
	}
	/**
	 * get name of movie
	 * @return
	 */
	public String getName()
	{
		
		return name;
	}
	/**
	 * set the rating of the movie
	 * @param r
	 */
	public void setRating(String r)
	{
		this.rating=r;
		
	}
	
	/**
	 * get the rating of the movie
	 * @return
	 */
	
	public  String getRating()
	{
		return rating;
		
	}
	/**
	 * set the day
	 * @param d
	 */
	
	public void setDay(int d)
	{
		this.day=d;
	}
	/**
	 * get the day
	 * @return
	 */
	public  int getDay()
	{
		return day;
	}
	/**
	 * set the time
	 * @param t
	 */
	
	public void setTime(int t)
	{
		this.time=t;
		
	}
	
	
	/**
	 * get the time
	 * @return
	 */
	
	public int getTime()
	{
		return time;
		
	}
	
	/**
	 * set id
	 * @param id
	 */
	public void setId(int id)
	{
		
		this.ID=id;
	}
	/**
	 * get Id
	 */
	@Override
	public int getId()
	{
		
		return ID;
	}
	
	/**
	 * set the format 
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
	 * get the format of the movie
	 * @return
	 */
	public String getFormat()
	{
		return fmt;
	}
	
	

	/**
	 * calculates price for ticket
	 */
	
	@Override
	public double  calculateTicketPrice()
	{
		double price=0.0;
		
		
		
		
	
		while( (!fmt.equals("3D")) &&
				(!fmt.equals("IMAX")))
			{
			
			
			
			 if(w.numMoviesToday(ID, day)==0&& 
			   (w.numThisMovie(ID, name)==0)&&
			   ((w.numVisits(this.ID)!=0)))
			{
				 return price=0.00;
				
			}
			
			 else
				{
				
				
					return price=9.99;
				}
			
			
			}
			
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
	 * get the type of the movie
	 * @return
	 */
	public String getType()
	{
		return fmt;
	}
	/**
	 * to String method
	 */
	@Override
	public String toString()
	{
		
		String str;
		str=type+"-"+ID+" "+super.toString()+" Price: "+currencyFormat.format(calculateTicketPrice());
		return str;
		
	}

}
