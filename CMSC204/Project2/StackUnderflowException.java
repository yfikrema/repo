
public class StackUnderflowException extends Exception {

	public StackUnderflowException() {
		super("pop/top called on an empty stack");
	}

	
}
