
public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("dequeue called on an empty queue");
	}

}
