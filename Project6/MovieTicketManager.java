import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.text.NumberFormat;
/**
 * MovieTicket Data Manager
 * @author Yared Fikremariam
 *
 */
public class MovieTicketManager implements MovieTicketManagerInterface {
	
	//private ArrayList<Ticket> ticketList;
	private ArrayList<Ticket> ticketList=new ArrayList<>();
	
	protected NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	
	/**
	 * Returns the number of times this patron has visited the theater this month
	 * @param id of the patron
	 * @return the number of times this patron has visited the theater this month
	 */
	public  int numVisits(int id)
	{
		int visits=0;
		
		for(int i=0;i<ticketList.size();i++)
		{
			if(ticketList.get(i).ID==id)
			{
				visits++;
			}
	
		}
		
		return visits;
	}
	
	
	
	/**
	 * Returns the number of times the patron has seen this movie
	 * @param id the id of the patron
	 * @param movie name of the movie
	 */
	public int numThisMovie(int id, String movie)
	{
		int num=0;
		
		for(int i=0;i<ticketList.size();i++)
		{
			if(id==ticketList.get(i).ID & ticketList.get(i).name.equals(movie))
			{
				num++;
			}
			
		}
		
		return num;
	}
	
	/**
	 * Checks to see if this patron already saw a movie today
	 * @param id id of patron
	 * @param date current date
	 * @return number of movies the patron has seen today
	 */
	public int numMoviesToday(int id, int date)
	{
		int nToday=0;
		
		for(int i=0;i<ticketList.size();i++)
		{
			if(id==ticketList.get(i).ID & ticketList.get(i).day==date)
			{
				nToday++;
			}
		}
		
		return nToday;
	}
	
	/**
	 * Adds a patron to the list and returns the ticket price
	 * @param m movie to be watched
	 * @param rating movie rating
	 * @param d date
	 * @param t time
	 * @param f feature
	 * @param type type of patron
	 * @param id id of the patron
	 * @return the price of the ticket. Returns -1 if type is invalid
	 */
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id)
	{
		double price=0.0;
		
		if(type.equals("Adult"))
		{
			Adult a=new Adult(movieN,rating,d,t,f,id);
			ticketList.add(a);
			return a.price;
	
		}
		
		else if(type.equals("Child"))
		{
			Child c=new Child(movieN,rating,d,t,f,id);
			ticketList.add(c);
			return c.price;
			
		}
		else if(type.equals("Employee"))
		{
			Employee e=new Employee(movieN,rating,d,t,f,id);
			ticketList.add(e);
			return e.price;
		}
		else if(type.equals("MoviePass"))
		{
			MoviePass p = new MoviePass(movieN,rating,d,t,f,id);
			ticketList.add(p);
			return p.price;
			
		}
		
		else return price;
	}
	
	
	/**
	 * Returns the sales for the entire month
	 * @return the sales for the entire month
	 */
	public double totalSalesMonth()
	{
		double total=0.0;
		for(int i=0;i<ticketList.size();i++)
		{
			
			total+=ticketList.get(i).price;
			
		}
		
		return total;
		
	}
	
	public String monthlySalesReport()
	{
		double aTotal=0.0;
		int aNum=0;
		double cTotal=0.0;
		int cNum=0;
		double eTotal=0.0;
		int eNum=0;
		double mTotal=0.0;
		int mNum=0;
		Ticket[] ar=ticketList.toArray(new Ticket[ticketList.size()]); 
		
		for(int i=0;i<ar.length;i++)
		{
			if(ar[i].type.equals("ADULT"))
			{
				aTotal+=ar[i].price;
				aNum++;
			}
			
			if(ar[i].type.equals("CHILD"))
			{
				cTotal+=ar[i].price;
				cNum++;
			}
			if(ar[i].type.equals("EMPLOYEE"))
			{
				eTotal+=ar[i].price;
				eNum++;
			}
			if(ar[i].type.equals("MOVIEPASS"))
			{
				mTotal+=ar[i].price;
				mNum++;
			}
			
			}
		
		String str;
		
		
		
		str="Monthly Sales Report"+"\n\n"+
		String.format("%28s %23s", "Sales","Number")+"\n"+
			       String.format("ADULT %20s %18d ",currencyFormat.format(aTotal),aNum)+"\n"+
			       String.format("CHILD %20s %18d ",currencyFormat.format(cTotal),cNum)+"\n"+
			       String.format("EMPLOYEE %11s %20d ",currencyFormat.format(eTotal),eNum)+"\n"+
			       String.format("MOVIEPASS %11s %18d ",currencyFormat.format(mTotal),mNum)+"\n\n\n"+
			       "Total Monthly Sales: "+currencyFormat.format(totalSalesMonth());
			       ;
		
		
		
		return str;
				
		
	}
	
	/**
	 * Returns an arraylist of strings that represent 3D tickets sorted by day
	 * @return an arraylist of strings that represent 3D tickets sorted by day
	 */
	public ArrayList<String> get3DTickets()
	{
		ArrayList<String> list=new ArrayList<String>();
		
		Ticket[] temp=new Ticket[ticketList.size()];
		
		Collections.sort(ticketList, new Comparator<Ticket>()
	       {
	    	   @Override
	    	   public int compare(Ticket a,Ticket b) 
	    	   {
	    		   return a.day - b.day;
	    	   }
	    	   
	       }
		);
	       
		Ticket[] ar=ticketList.toArray(new Ticket[ticketList.size()]); 
		
		for(int i=0;i<ar.length;i++)
		{
			if(ar[i].fmt.equals("3D"))
			{
				temp[i]=ar[i];
			}
			
		}
		
		
		
		for(int i=0;i<temp.length;i++)
		{
			if(temp[i]!=null)
			{
			list.add(temp[i].toString());
			}
			
		}
		
		
		return list;
		
	}
	/**
	 * Returns an arrayList of strings which represent tickets, in chronological order
	 * use the toString of each Ticket in the ticketList
	 * @return an arrayList of strings which represent tickets, in chronological order
	 */
	public ArrayList<String> getAllTickets()
	{
		ArrayList<String> list=new ArrayList<String>();
		
		Collections.sort(ticketList, new Comparator<Ticket>()
	       {
	    	   @Override
	    	   public int compare(Ticket a,Ticket b) 
	    	   {
	    		   return a.day - b.day;
	    	   }
	    	   
	       }
		);
	       
		
		 if(ticketList!=null)
		 {
		
		for(int i=0;i<ticketList.size();i++)
		{
			list.add(ticketList.get(i).toString());
			
		}
		 }
		
		
		return list;
		
	}

	/**
	 * Returns an Arraylist of string representation of MoviePass tickets sorted by movieId
	 * @return an Arraylist of string representation of MoviePass tickets sorted by movieId
	 */
	public ArrayList<String> getMoviePassTickets()
	{
		
		
		Ticket[] temp=new Ticket[ticketList.size()];
		ArrayList<String> list=new ArrayList<String>();
		
		Collections.sort(ticketList, new Comparator<Ticket>()
		{
			@Override
			public int compare(Ticket a,Ticket b)
			{
				return a.ID - b.ID;
			}
		}

		
	);
		
		Ticket[] ar=ticketList.toArray(new Ticket[ticketList.size()]); 
		
		for(int i=0;i<ar.length;i++)
		{
			if(ar[i].type.equals("MOVIEPASS"))
			{
				temp[i]=ar[i];
			}
			
		}
		
		
		
		
		for(int i=0;i<temp.length;i++)
		{
			
			if(temp[i]!=null)
			{
			
			list.add(temp[i].toString());
			}
			 
			
		}
		
		
		return list;
	}
	
	
	/**
	 * Reads from a file and populates an arraylist of Ticket objects
	 * @param file file to be read from
	 * @throws FileNotFoundException when file is not found
	 */
	public void readFile(File file) throws FileNotFoundException
	{
		ticketList=new ArrayList<Ticket>(12);
		String line="";
		String name,rating,format,type;
		int day,time,id;
		
		try
		{
			Scanner inFile=new Scanner(file);
			
			
			
			while(inFile.hasNext())
				{
				
				line=inFile.nextLine();
				
				String[] temp=line.split(":");
				//int columns=temp.length;
				name=temp[0];
				rating=temp[1];
				day=Integer.parseInt(temp[2]);
				time=Integer.parseInt(temp[3]);
				format=temp[4];
				type=temp[5];
				id=Integer.parseInt(temp[6]);
				
				if(type.equals("Adult"))
				{
					ticketList.add(new Adult(name,rating,day,time,format,id));
					
				}
				
				else if(type.equals("Child"))
				{
					ticketList.add(new Child(name,rating,day,time,format,id));
					
				}
				else if(type.equals("Employee"))
				{
					ticketList.add(new Employee(name,rating,day,time,format,id));
					
				}
				else if(type.equals("MoviePass"))
				{
					ticketList.add(new MoviePass(name,rating,day,time,format,id));
					
				}
				
				}
			
			}
	
		catch(IOException e)
		{
			e.getMessage();
			
		}
	
			
	}
	
	/**
	 * sorts ArrayList by day
	 */
	public void sortByDay()
	{
		Collections.sort(ticketList, new Comparator<Ticket>()
	       {
	    	   @Override
	    	   public int compare(Ticket a,Ticket b) 
	    	   {
	    		   return a.day - b.day;
	    	   }
	    	   
	       }
		);
	       
	}
	
	/**
	 * sorts ArrayList by ID
	 */
	public void sortById()
	{
		Collections.sort(ticketList, new Comparator<Ticket>()
				{
					@Override
					public int compare(Ticket a,Ticket b)
					{
						return a.ID - b.ID;
					}
				}
		
				
			);
		
	}
	
}
