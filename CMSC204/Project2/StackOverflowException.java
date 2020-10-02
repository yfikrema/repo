
public class StackOverflowException extends Exception {

	public StackOverflowException() {
		super("push called on a full stack");
	}

}
