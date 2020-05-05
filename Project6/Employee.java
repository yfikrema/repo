/**
 * Employee class extends Ticket
 * @author Yared Fikremariam
 *
 */

public class Employee extends Ticket{
	
	protected int snM;
	private final double matinee=10.5;
	private final double evening=13.5;
	/**
	 * no-arg constructor
	 */
	Employee()
	{
		super();
		
	}
	/**
	 * parametrized constructor 
	 * @param n name of the movie
	 * @param r rating
	 * @param d day
	 * @param t time
	 * @param f format
	 * @param iD id of the employee
	 */
	Employee(String n,String r,int d,int t,String f,int iD)
	{
		
		super(n,r,d,t,f,iD);
		price=calculateTicketPrice();
		type="EMPLOYEE";
		MovieTicketManager m=new MovieTicketManager();
		snM=m.numVisits(iD);
		setFormat(f);
	}
	
	/**
	 * parametrized constructor 
	 * @param n name of the movie
	 * @param r rating
	 * @param d day
	 * @param t time
	 * @param f format
	 * @param iD id of the employee
	 */
	Employee(String n,String r,int d,int t,String f,int iD,int s)
	{
		
		super(n,r,d,t,f,iD);
		snM=s;
		
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
	 * set id
	 * @param id
	 */
	public void setId(int id)
	{
		
		this.ID=id;
	}
	/**
	 * get id
	 */
	@Override
	public int getId()
	{
		
		return ID;
	}
	
	/**
	 * set format
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
		else if (fmt.equals("NONE")) 
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
	 * calculate ticket price
	 */
	@Override
	public double  calculateTicketPrice()
	{
		double price=0.0;
		//MovieTicketManager m=new MovieTicketManager();
		
		if(snM<2)
		{
			return price =0.0;
		}
		else 
		{
			if(time<18)
			{
				if(fmt.equals("3D"))
				{
					price=(0.5*(matinee+2.5))+(0.5*(matinee+2.5)*TAX); 
					
				}
				else if(fmt.equals("IMAX"))
				{
					price=(0.5*(matinee+3.0))+(0.5*(matinee+3.0)*TAX); 
					
				}
				
				else
					price=(0.5*matinee)+(0.5*matinee*TAX); 
				
			}
			
			if(time>=18)
			{

				if(fmt.equals("3D"))
				{
					price=(0.5*(evening+2.5))+(0.5*(evening+2.5)*TAX); 
					
				}
				else if(fmt.equals("IMAX"))
				{
					price=(0.5*(evening+3.0))+(0.5*(evening+3.0)*TAX); 
					
				}
				else 
					price=(0.5*evening)+(0.5*evening*TAX); 
			}
			
			
			
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
		str=type+"-"+ID+" "+super.toString()+" Price: "+currencyFormat.format(calculateTicketPrice());
		return str;
		
	}
}
