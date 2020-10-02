import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Yared Fikremariam
 *
 */
public class NotationQueue<T> implements QueueInterface<T> {

	private ArrayList<T> arrList;
	private int capacity;

	public NotationQueue() {
		arrList = new ArrayList<T>();
		capacity = 100;
	}

	public NotationQueue(int size) {
		arrList = new ArrayList<T>(size);
		capacity = size;

	}

	/**
	 * Determines if Queue is empty
	 * 
	 * @return true if Queue is empty, false if not
	 */

	@Override
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Determines of the Queue is empty
	 * 
	 * @return
	 */

	@Override
	public boolean isFull() {
		if (this.size() == capacity) {
			return true;
		}
		return false;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * 
	 * @return the element at the front of the Queue
	 */

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.arrList.isEmpty()) {
			throw new QueueUnderflowException();

		}

		T val = this.arrList.get(0);
		this.arrList.remove(0);

		return val;
	}

	/**
	 * Number of elements in the Queue
	 * 
	 * @return the number of elements in the Queue
	 */

	@Override
	public int size() {

		return this.arrList.size();
	}

	/**
	 * Adds an element to the end of the Queue
	 * 
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {

		if (this.isFull()) {
			throw new QueueOverflowException();
		}

		this.arrList.add(e);

		return true;
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning
	 * of the string is the front of the queue
	 * 
	 * @return string representation of the Queue with elements
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
	 * Returns the string representation of the elements in the Queue, the beginning
	 * of the string is the front of the queue Place the delimiter between all
	 * elements of the Queue
	 * 
	 * @return string representation of the Queue with elements separated with the
	 *         delimiter
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
	 * Fills the Queue with the elements of the ArrayList, First element in the
	 * ArrayList is the first element in the Queue YOU MUST MAKE A COPY OF LIST AND
	 * ADD THOSE ELEMENTS TO THE QUEUE, if you use the list reference within your
	 * Queue, you will be allowing direct access to the data of your Queue causing a
	 * possible security breech.
	 * 
	 * @param list elements to be added to the Queue
	 */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy = new ArrayList<T>();
		listCopy.addAll(list);

		for (int i = 0; i <= listCopy.size() - 1; i++) {
			this.arrList.add(listCopy.get(i));
		}

	}

}
