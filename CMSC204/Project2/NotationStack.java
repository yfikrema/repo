import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Yared Fikremariam
 *
 */

public class NotationStack<T> implements StackInterface<T> {

	private ArrayList<T> arrList;
	private int capacity;

	public NotationStack() {
		arrList = new ArrayList<T>();
		capacity = 100;
	}

	public NotationStack(int size) {
		arrList = new ArrayList<T>(size);
		capacity = size;
		
	}

	/**
	 * Determines if Stack is empty
	 * 
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {

		if (this.size() == 0) {
			return true;
		}

		else
			return false;
	}

	/**
	 * Determines if Stack is full
	 * 
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {

		if (this.size() == capacity) {
			return true;
		} else
			return false;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * 
	 * @return the element at the top of the Stack
	 */

	@Override
	public T pop() throws StackUnderflowException {

		if (this.arrList.isEmpty()) {
			throw new StackUnderflowException();
		}

		T val = this.arrList.get(this.arrList.size() - 1);

		this.arrList.remove(this.arrList.size() - 1);

		return val;
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * 
	 * @return the element at the top of the Stack
	 */

	@Override
	public T top() throws StackUnderflowException {
		if (this.arrList.isEmpty()) {
			throw new StackUnderflowException();
		}

		T val = this.arrList.get(this.arrList.size() - 1);
		return val;

	}

	/**
	 * Number of elements in the Stack
	 * 
	 * @return the number of elements in the Stack
	 */

	@Override
	public int size() {

		return this.arrList.size();
	}

	/**
	 * Adds an element to the top of the Stack
	 * 
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */

	@Override
	public boolean push(T e) throws StackOverflowException {

		if (this.isFull()) {
			throw new StackOverflowException();
		}

		this.arrList.add(e);
		return true;
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top, the
	 * beginning of the String is the bottom of the stack
	 * 
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {

		String st = "";

		for (int i = 0; i <= this.size() - 1; i++) {

			st += this.arrList.get(i);
		}

		return st;
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning
	 * of the string is the bottom of the stack Place the delimiter between all
	 * elements of the Stack
	 * 
	 * @return string representation of the Stack from bottom to top with elements
	 *         separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {

		String st = "";

		for (int i = 0; i <= this.size() - 1; i++) {
			st += this.arrList.get(i) ;
			
			if(i != (this.size() - 1))
			{
				st += delimiter;
			}
			
		}

		return st;

	}

	/**
	 * Fills the Stack with the elements of the ArrayList, First element in the
	 * ArrayList is the first bottom element of the Stack YOU MUST MAKE A COPY OF
	 * LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the list reference
	 * within your Stack, you will be allowing direct access to the data of your
	 * Stack causing a possible security breech.
	 * 
	 * @param list elements to be added to the Stack from bottom to top
	 */

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy = new ArrayList<T>();
		listCopy.addAll(list);
		
//		for (int i = listCopy.size() - 1; i >= 0; i--) {
//			arrList.add(listCopy.get(i));
//		}
//		
		
		for (int i = 0; i <= listCopy.size() - 1; i++) {
			arrList.add(listCopy.get(i));
	}

	}

}
