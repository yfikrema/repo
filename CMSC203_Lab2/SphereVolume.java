import java.util.Scanner;
public class SphereVolume {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("This program calculates volume of a sphere");
		System.out.println("Enter the diameter of the sphere,\ndiameter must be positive");
		double daim = key.nextDouble();
		//String input = key.next();
		//double daim =Double.parseDouble(input);
		double radius=(daim/2);
		double volume= (4.0/3)*(Math.PI)*(Math.pow(radius, 3));
		System.out.println("The volume of the sphere is: "+Math.abs(volume));
		
	}

}
