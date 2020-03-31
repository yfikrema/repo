package application;
/**
 * 
 */


/**Represents management company object 
 * 
 * @author Yared Fikremariam
 *
 */

public class ManagementCompany {
	
	
		private final int MAX_PROPERTY=5;
		private double mgmFeeper;
		private String name ;
		private Property[] properties;
		private String taxID;
		private final int MGMT_WIDTH=10;
		private final int MGMT_DEPTH=10;
		private Plot plot;
		
		
		/**
		 * No-Arg Constructor that creates a ManagementCompany object using empty strings 
		 * and the plot set to a Plot with x, y set to 0 , width and depth set to 10.
		 *properties array is initialized here as well.
		 */
		
		ManagementCompany()
		{
			this.name ="";
			this.taxID="";
			this.mgmFeeper=0;
			properties=new Property[MAX_PROPERTY];
			this.plot=new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
			
		}

		
		/**
		 *   Constructor Creates a ManagementCompany object using the passed information.
		plot is set to a Plot with x, y set to 0 , width and depth set to 10
		 * @param name
		 * @param taxID
		 * @param mgmFee
		 */
		ManagementCompany(String name,String taxID,double mgmFee)
		{
			this.name=name;
			this.taxID=taxID;
			this.mgmFeeper=mgmFee;
			this.properties=new Property[MAX_PROPERTY];
			this.plot=new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
			
		}
		
		
		/**
		 * Constructor Creates a ManagementCompany object using the passed information.
		 * @param name
		 * @param taxID
		 * @param mgmFee
		 * @param x
		 * @param y
		 * @param widith
		 * @param depth
		 */
		ManagementCompany(String name,String taxID,double mgmFee,int x,int y,int widith,int depth)
		{
			
			this.name=name;
			this.taxID=taxID;
			this.mgmFeeper=mgmFee;
			this.properties=new Property[MAX_PROPERTY];
			this.plot =new Plot(x,y,widith,depth);
			
		}
		
		/**
		 * Copy Constructor that creates a ManagementCompany object from 
		 * another ManagementCompany object
		 * @param otherCompany
		 */
		ManagementCompany(ManagementCompany otherCompany)
		{
			
			this.name=otherCompany.name;
			this.taxID=otherCompany.taxID;
			this.mgmFeeper=otherCompany.mgmFeeper;
			this.properties=otherCompany.properties;
			this.plot =otherCompany.plot;
			//Plot plot =new Plot(otherCompany.plot);
		}
		
		
		
		/**
		 *  Creates a property object by copying from another property and 
		 *  adds it to the "properties" array.
		 * @param property
		 * @return
		 */

	
		public int addProperty(Property property)
		{
			
			int j=0;
			Property newprop=new Property(property);
			 if(property==null)
				{
					return -2;
				}
			 
			
			if (!(this.plot.encompasses(newprop.getPlot())))
				{
					return -3;
					
				}
				 
				
				
				
		   for(int i=0;i<5;i++)
			{
			   
			   {
				   if(properties[i]!=null)
				   {
					 if(properties[i].getPlot().overlaps(newprop.getPlot()))
						{
							
							return -4;
						}
					}
				   
			   }
				if(properties[i]==null)
				{
				properties[i]=newprop;
					j=i;
					
					return j;	
				}
					
				
				
			}
			if(j==MAX_PROPERTY)
			 
			return -1;
			 
			 
			return -1;
					
				
		}
			
			
			
			/**
			 * Creates a property object with a default plot and adds it to the "properties" array.
			 * @param propertyName
			 * @param city
			 * @param rentAmount
			 * @param owner
			 * @return
			 */
		
		public int addProperty(String propertyName,String city,double rentAmount,String owner)
		{
			
			int j=0;
			Property newprop=new Property(propertyName,city,rentAmount,owner);
			

			if (!(this.plot.encompasses(newprop.getPlot())))
				{
					return -3;
					
				}
				
				 
						
		   for(int i=0;i<5;i++)
			{
			   {
				   if(properties[i]!=null)
				   {
					 if(properties[i].getPlot().overlaps(newprop.getPlot()))
						{
							
							return -4;
						}
					}
				   
			   }
			   
				if(properties[i]==null)
				{
				properties[i]=newprop;
					j=i;
					
					return j;	
				}
					
				
				
			}
			if(j==MAX_PROPERTY)
			 
			return -1;
			 
			else 
			
			return -1;
		}

		/**
		 * Creates a property object and adds it to the "properties" array.
		 *return -1 if the array is full ,
		 *-2 if the Property object is null
	     *-3 if if management company does not encompass the property plot
		 *-4 if property plot overlaps ANY of properties in array
		 *otherwise return the index of the array where the property was added.
		 * @param city
		 * @param owner
		 * @param propertyName
		 * @param rentAmount
		 * @param x
		 * @param y
		 * @param widith
		 * @param depth
		 * @return
		 */
		public int addProperty(String city,String owner,String propertyName,double rentAmount,int x,int y, int widith,int depth)
		
		{
			
			int j=0;
			Property newprop=new Property(propertyName,city,rentAmount,owner,x,y,widith,depth);
			

			if (!(this.plot.encompasses(newprop.getPlot())))
				{
					return -3;
					
				}
				
				
				
		   for(int i=0;i<5;i++)
			{
				
			   
			   if(properties[i]!=null)
					
				{
				 if(properties[i].getPlot().overlaps(newprop.getPlot()))
					{
						
						return -4;
					}
				}
			   
			   
			   if(properties[i]==null)
				{
				properties[i]=newprop;
					j=i;
					
					return j;	
				}
					
				
				
			}
			
		   if(j==MAX_PROPERTY)
			 
			return -1;
		   else return -1; 
			 			
			//return j;
		}
		
        /**
         * Return the MAX_PROPERTY constant that represents the size of the "properties" array.
         * @return
         */
		public int getMAX_PROPERTY()
		{
			return MAX_PROPERTY;
		}
		
		
		/**
		 *  Displays the information of the property at index i
		 * @param i
		 * @return
		 */
		public  String displayPropertyAtIndex(int i)
		{
			
            return  "\tProperty Name: " + properties[i].getPropertyName()+"\n\tLocated in: " + properties[i].getCity() + "\n\tBelonging to: " + properties[i].getOwner()+ "\n\tMortgage Amount: " + properties[i].getRentAmount();
		
			
		}
		
		/**
		 *  This method finds a property within the properties array that has the maximum rent amount 
		 *  and returns the rent amount.
		 * @return
		 */
		public double maxRentProp()
		{
			return properties[maxRentPropertyIndex()].getRentAmount();
			
		}
		
		/**
		 *  This method finds the index of the property with the maximum rent amount.
		 * @return
		 */
		public int maxRentPropertyIndex()
		{
			int maxindex=0;
			for(int i=0;i<MAX_PROPERTY;i++)
			{
				if(properties[i]!=null)
				{
				if(properties[i].getRentAmount()>=properties[maxindex].getRentAmount())
				{
					maxindex=i;
				}
				
				
			}
			}
			return maxindex;
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
		 * returns name of Management Company
		 * @return
		 */
		public String getName()
		{
			
			return this.name;
		}
		
		/**
		 *   This method accesses each "Property" object within the array "properties" and sums up 
		 *   the property rent and returns the total amount.
		 * @return
		 */
		public double totalRent()
		{
			double totalRent=0;
			for(int i=0;i<5;i++)
			{
				  if(properties[i] != null)
				  {
				
				totalRent+=properties[i].getRentAmount();
				  }
			}
		
			return totalRent;
		}
		
		/**
		 * calculates and returns total management fee
		 * @return
		 */
		private double TotalFee()

		   {

		       double fee=0;

		       for(int i=0;i<5;++i)

		       {
		    	   if(properties[i]!=null)
               {
		           fee+=mgmFeeper*properties[i].getRentAmount()/100;

		       }

		      		       }
		       return fee;


		   }
		
        
		/**
		 *  Displays the information of all the properties in the "properties" array.
		 */
		
		public String toString()
		{
			String out="";
			for(int i=0;i<5;i++)
			{
				  if(properties[i] != null)
				  {
				out+=properties[i].toString()+"\n\n";
				  }
				
			}
			
		//	System.out.println("List of the properties for "+this.name+", taxID:"+this.taxID);
			//System.out.println("\n_________________________________________________________\n");
			return "List of the properties for "+this.name+", taxID:"+this.taxID+
					"\n_______________________________________________________________\n"+
			out+"______________________________________________________________\n Total management Fee: "+
					TotalFee();
			
		}

}
