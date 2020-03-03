import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Random;
/**
 * Driver for the Toy class
 * @author Yared Fikremariam
 * @version 1.0
 *
 */
public class ToyDriver {
	
	/**
	 * Main method for the ToyDriver class
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		
		
		
				DecimalFormat dollar = new DecimalFormat("#,##0.00"); //Creates a new DecimalFormat object
				JOptionPane.showMessageDialog(null, "Welcome to the Toy Company\nto choose gifts for young children ");
				System.out.println("BIRTHDAY GIFTS");
			
				Random rand=new Random();   //Creates a new random object for the five digit order number
				String rnd=String.format("%05d", rand.nextInt(99999));
				double cost=0;
				cost+= (dialogue());  //Gets the total cost of the order from the dialogue method
			
			 
				System.out.println("The total cost of your order is $"+ dollar.format(cost)+"\nOrder number is "+rnd);//Displays total cost in dollar format 
				                                                                                                      //and a random five digit order number
				System.out.println("Programmer Yared Fikremariam");
			 
				System.exit(0); // Exits thread

	             }

		
		/**
		 * This method gets the name, age of the child 
		 * and lets the user choose toy
		 
		 * @return The total cost of the order
		 */
		public static double dialogue()
		{
					Toy nwToy= new Toy(); //Creates a new Toy object
					String inN="";
					double cost=0;
					cost+=nwToy.getCost();
			
		do
			{
			 		DecimalFormat dollar = new DecimalFormat("#,##0.00");
					
					String nme = JOptionPane.showInputDialog("Enter the name of the child");//Read the name of the child
			
					String inA =JOptionPane.showInputDialog("How old is the child?");//Read the age of the child
					
					int age= Integer.parseInt(inA);//Converts input to integer 
			
					nwToy.setAge(age);//Sets age based on input
					
					String ty =JOptionPane.showInputDialog("Choose a toy:a plushie,blocks, or a book");
			
					nwToy.setToy(ty);//Sets toy
					
			
			
           if(nwToy.ageOK())   //Validates age
				
				   {
					nwToy.setCost(ty); //Sets toy if age is ok
					System.out.println("The gift for "+ nme+" "+nwToy.getAge()+" years old is "+nwToy.getToy()+" $" + dollar.format(nwToy.getCost()));
				
				
					
					}
			
			
			
			else	
				
			{
					String in=JOptionPane.showInputDialog("The toy you entered is age inappropriate\nDo you want to cancel?");
	          
					if (in.equalsIgnoreCase("yes")) //Lets user start over
					{
						dialogue();
		
					}
					
					nwToy.setCost(ty); //Sets cost if the user wants to continue
					System.out.println("The gift for "+ nme+" "+nwToy.getAge()+" years old is "+nwToy.getToy()+" $" + dollar.format(nwToy.getCost()));
		
		
					
		
			}
		
		
					String inC = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
					nwToy.addCard(inC);//Adds card
					String inB =JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");
					nwToy.addBalloon(inB);	//Adds a balloon
					cost += nwToy.getCost();	//Gets cost with additions
					//System.out.println(cost);
			
					inN =JOptionPane.showInputDialog("Do you want another toy? Yes or No"); // Asks user if he/she wants another toy
		 
		
		 	
			}
		
					
		
				while(inN.equalsIgnoreCase("yes"));
				return cost;	//returns the total cost to main
		
	
		
		
		
		}
}
 