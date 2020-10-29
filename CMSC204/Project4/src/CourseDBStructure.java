import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Course Database Structure Class
 * 
 * @author Yared Fikremariam
 * 
 */

public class CourseDBStructure implements CourseDBStructureInterface {

	protected LinkedList<CourseDBElement>[] hashTable;
	protected int n;

	/**
	 * Constructor
	 * 
	 * @param size size of the hash table
	 */
	public CourseDBStructure(int size) {

		this.n = size;

		hashTable = new LinkedList[n];

	}

	/**
	 * Second Constructor
	 * 
	 * @param test
	 * @param size
	 */
	public CourseDBStructure(String test, int size) {

		this.n = size;

		hashTable = new LinkedList[n];

	}

	/**
	 * adds cde element to the hashtable
	 * 
	 * @param element the CDE to be added
	 */
	@Override
	public void add(CourseDBElement element) {

		int ip;
		LinkedList<CourseDBElement> list = new LinkedList<CourseDBElement>();

		ip = element.crn % n;
		//System.out.println(ip + " " + element.crn + " " + n);

		if (hashTable[ip] == null) {

			list.add(element);
			hashTable[ip] = (LinkedList<CourseDBElement>) list.clone();
		}

		list = hashTable[ip];
		if (!list.contains(element)) {
			list.addLast(element);
			hashTable[ip] = (LinkedList<CourseDBElement>) list.clone();

		}

	}

	/**
	 * 
	 * Checks if the hashtable contains cde with the given crn
	 * 
	 * @param element the CDE to be added
	 * @throws IOException
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {

		int ip = crn % n;
		LinkedList<CourseDBElement> list = new LinkedList<CourseDBElement>();
		CourseDBElement result = null;
		list = hashTable[ip];
		ArrayList<CourseDBElement> arr = new ArrayList<CourseDBElement>(list);

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).crn == crn) {

				result = arr.get(i);
			}
		}

		if (result == null) {
			throw new IOException();
		}

		return result;
	}

	/**
	 * returns the size of the hashtable
	 */
	@Override
	public int getTableSize() {

		return this.hashTable.length;
	}

}
