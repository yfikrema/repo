
public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("enqueue called on a full queue");
		
	}

}
