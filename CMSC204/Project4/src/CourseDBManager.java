import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	public CourseDBStructure cds;

	public CourseDBManager() {
		cds = new CourseDBStructure(50);
	}

	/**
	 * adds cde element to the hashtable
	 * 
	 * 
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {

		CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);

		cds.add(cde);

	}

	@Override
	public CourseDBElement get(int crn) {
		CourseDBElement cr = null;
		try {
			cr = cds.get(crn);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return cr;
	}

	/**
	 * reads text file and enters it to the Database
	 * 
	 * 
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {

		String line = "";
		Scanner inFile = new Scanner(input);

		while (inFile.hasNext()) {

			line = inFile.nextLine();

			String[] temp = line.split(" ");

			CourseDBElement cde = new CourseDBElement(temp[0], Integer.valueOf(temp[1]), Integer.valueOf(temp[2]),
					temp[3], temp[4]);

			cds.add(cde);

		}

	}

	/**
	 * Shows all elements of the database
	 */
	@Override
	public ArrayList<String> showAll() {

		LinkedList<CourseDBElement> list;
		ArrayList<String> arr = new ArrayList<String>();

		for (int i = 0; i < this.cds.hashTable.length; i++) {

			String st = "";

			if (this.cds.hashTable[i] != null)

			{
				list = (LinkedList<CourseDBElement>) cds.hashTable[i].clone();

				ListIterator<CourseDBElement> itr = list.listIterator();

				while (itr.hasNext()) {
					st += "\n" + itr.next().toString();
				}

				arr.add(st);

			}

		}

		return arr;
	}

}
