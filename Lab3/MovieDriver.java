import java.util.Scanner;
public class MovieDriver {

	public static void main(String[] args) {
		
		
		Movie NewMovie = new Movie();
		char res;
	   
		do
		{ 
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the title of the movie");
			
			String title=in.nextLine();
			NewMovie.setTitle(title);
			System.out.println("Enter the movie's rating");
			String rating=in.nextLine();
			NewMovie.setRating(rating);
			System.out.println("Enter the number of tickets sold");
			int notik=in.nextInt();
			NewMovie.setSoldTickets(notik);
			System.out.println(NewMovie.toString());
			in.nextLine();
			System.out.print("Do you want to enter another? (y or n)\n");
			
			String input=in.nextLine();
			res =input.charAt(0);
		
			
		
		}
		
		while (res=='y');
			
		
		
		System.out.println("Goodbye");
		System.exit(0);
		
		
		
		

	}

}
