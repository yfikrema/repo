package application;
/**
 * 
 */


/**Represents a Property object 
 * @author Yared Fikremariam
 *
 */
public class Property {
	
	
	
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * No-arg Constructor, creates a new object with default values of empty strings,
	 *  0 for rent amount, and default Plot (sets the x, y values to zero, depth and width to 1)
	 */
	
	
	Property()
	{
		
		city="";
		owner="";
		propertyName="";
		rentAmount=0;
	    plot=new Plot();
		
	}
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p a property object
	 */
	Property (Property p)
	{
		
		this.city=p.city;
		this.owner=p.owner;
		this.propertyName=p.propertyName;
		this.rentAmount=p.rentAmount;
		this.plot=p.plot;
		
	}
	
	/**
	 *  Parameterized Constructor, no Plot information provided
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */
	
	Property(String propertyName,String city,double rentAmount,String owner)
	{
		
		this.city=city;
		this.owner=owner;
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		
		
	}
	/**
	 * Parameterized constructor, plot information provided
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param widith
	 * @param depth
	 */
	Property(String propertyName,String city,double rentAmount,String owner,int x,int y, int widith,int depth)
	{
		this.city=city;
		this.owner=owner;
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		this.plot=new Plot(x,y,widith,depth);
		
		
	}
	
	/**
	 * set the Plot values and return the Plot instance
	 * @param x
	 * @param y
	 * @param widith
	 * @param depth
	 * @return plot
	 */
	public Plot setPlot(int x,int y,int widith,int depth)
	{
		Plot plot=  new Plot(x,y,widith,depth);
		return plot;
		
	}
	
	
	/**
	 *  set the city
	 * @param city
	 */
	public void setCity(String city)
	{
		this.city=city;
		
	}
	
	/**
	 * set the owner's name
	 * @param owner
	 */
	public void setOwner(String owner)
	{
		this.owner=owner;
		
	}
	
	
	/**
	 * sets the property name
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName)
	{
		this.propertyName=propertyName;
		
	}

	
	/**
	 * sets the rent amount
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount=rentAmount;
		
	}
	
	/**
	 * returns a plot object
	 * @return
	 */
	public Plot getPlot()
	{
		
		return this.plot;
	}
	
	/**
	 * returns city
	 * @return
	 */
	public String getCity()
	{
		return city;
		
	}
	
	/**
	 * returns the owner's name
	 * @return
	 */
	public String getOwner()
	{
		return owner;
		
	}
	
	/**
	 * returns the property name
	 * @return
	 */
	public String getPropertyName()
	{
		return propertyName;
		
	}
	
	/**
	 * return's the rent amount
	 * @return
	 */
	public double getRentAmount()
	{
		return rentAmount;
		
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property. 
	 */
	public String toString()
	{
		return "Property Name: "+ this.propertyName +"\n"+"Located in "+ this.city+"\nBelonging to: "+ this.owner+"\nRent Amount: "+this.rentAmount+" "; 
		
	}
}
