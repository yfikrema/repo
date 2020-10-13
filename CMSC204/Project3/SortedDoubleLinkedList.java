import java.util.Comparator;
import java.util.ListIterator;

/**
 * 
 * @author Yared Fikremariam
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	Comparator c = null;

	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		c = comparator2;

	}

	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * 
	 * @param data the data to be added to the list
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		if (data == null) {
			return null;
		} else {
			Node n = new Node(data);

			if (head.next.data == null) {

				head.next = n;
				n.previous = head;
				n.next = tail;
				tail.previous = n;

			}

			else if (c.compare(data, head.next.data) <= 0) {
				Node cur = head.next;
				Node p = cur.previous;

				p.next = n;
				n.previous = p;
				n.next = cur;
				cur.previous = n;

			}

			else if (c.compare(data, tail.previous.data) >= 0) {

				Node t = tail.previous;

				n.next = tail;
				tail.previous = n;
				n.previous = t;
				t.next = n;

			}

			else {

				Node nx = head.next;
				Node pre = null;
				while (c.compare(data, nx.data) > 0) {
					pre = nx;
					nx = nx.next;
				}

				pre.next = n;
				n.previous = pre;
				n.next = nx;
				nx.previous = n;
			}

		}
		N++;
		return this;

	}

	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException();
	}

	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException();
	}

	public ListIterator<T> iterator() {
		return new DoubleListIterator();
	}

}
