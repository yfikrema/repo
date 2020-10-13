import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Yared Fikremariam
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

	protected int N;
	protected Node head;
	protected Node tail;

	BasicDoubleLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.previous = head;
	}

	protected class Node {

		protected T data;
		protected Node previous;
		protected Node next;

		Node(T item) {
			data = item;
			next = null;
			previous = null;
		}

		Node() {
			data = null;
			next = null;
			previous = null;

		}
	}

	/**
	 * Adds an element to the front of the list
	 * 
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		Node last = tail.previous;
		Node n = new Node(data);
		last.next = n;
		n.previous = last;
		n.next = tail;
		tail.previous = n;
		N++;

		return this;
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node f = head.next;
		Node n = new Node(data);
		f.previous = n;
		n.next = f;
		n.previous = head;
		head.next = n;

		N++;

		return this;

	}

	/**
	 * Returns but does not remove the first element from the list. If there are no
	 * elements the method returns null.
	 * 
	 * @return the data element or null
	 */
	public T getFirst() {
		if (head.next.data == null) {
			return null;
		} else
			return head.next.data;
	}

	/**
	 * Returns but does not remove the last element from the list. If there are no
	 * elements the method returns null.
	 * 
	 * @return the data element or null
	 */
	public T getLast() {
		if (tail.previous.data == null) {
			return null;
		} else
			return tail.previous.data;
	}

	/**
	 * Removes and returns the first element from the list. If there are no elements
	 * the method returns null.
	 * 
	 * @return the data element or null
	 */
	public T retrieveFirstElement() {
		if (head.next.data == null) {
			return null;
		} else {
			Node t = head.next;
			head.next = head.next.next;
			head.next.previous = head;
			N--;
			return t.data;
		}

	}

	/**
	 * Removes and returns the last element from the list. If there are no elements
	 * the method returns null.
	 * 
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		if (tail.previous.data == null) {
			return null;
		} else {

			Node t = tail.previous;
			tail.previous = tail.previous.previous;
			tail.previous.next = tail;
			N--;
			return t.data;

		}

	}

	/**
	 * Removes the first instance of the targetData from the list.
	 * 
	 * @param targetData the data element to be removed
	 * @param comparator the comparator to determine equality of data elements
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {

		Node p = null;
		Node c = head.next;
		while (c.data != null) {

			if (comparator.compare(c.data, targetData) == 0) {

				if (comparator.compare(head.next.data, c.data) == 0) {

					head.next = head.next.next;
					head.next.previous = head;
					c = c.next;

				}

				else if (comparator.compare(tail.previous.data, c.data) == 0) {

					tail.previous = c.previous;
					c.previous.next = tail;
					c = c.next;
				}

				else

				{
					p = c.previous;
					p.next = c.next;
					c.next.previous = p;
					c = c.next;

				}

				N--;
			}

			else {
				p = c;
				c = c.next;
			}

		}

		return this;

	}

	/**
	 * Returns the value of the instance variable you use to keep track of size.
	 * 
	 * @return the size of the linked list
	 */
	public int getSize() {
		return N;
	}

	/**
	 * Returns true if if the list is empty
	 * 
	 * @return true or false
	 */
	public boolean isEmpty() {
		return N == 0;
	}

	/**
	 * Returns an arraylist of the items in the list from head of list to tail of
	 * list
	 * 
	 * @return an arraylist of the items in the list
	 */
	public ArrayList<T> toArrayList() {
		Node c = head.next;
		Node p = null;
		ArrayList<T> arrList = new ArrayList<T>();

		while (c.data != null) {
			arrList.add(c.data);

			c = c.next;
			p = c;
		}

		return arrList;

	}

	/**
	 * List iterator
	 */
	@Override
	public ListIterator<T> iterator() {

		return new DoubleListIterator();
	}

	protected class DoubleListIterator implements ListIterator<T> {

		protected int index = 0;
		protected Node current;
		protected Node lastAccessed;

		DoubleListIterator() {
			current = head.next;
			lastAccessed = null;
			index = 0;
		}

		@Override
		public boolean hasNext() {

			return index < N;
		}

		@Override
		public T next() {

			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			T item = current.data;
			current = current.next;
			lastAccessed = current;

			index++;

			return item;
		}

		@Override
		public boolean hasPrevious() {

			return index > 0;
		}

		@Override
		public T previous() {

			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}

			current = current.previous;
			lastAccessed = current;
			T item = current.data;

			index--;

			return item;
		}

		@Override
		public int nextIndex() {

			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {

			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();

		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
		}

	}

}
