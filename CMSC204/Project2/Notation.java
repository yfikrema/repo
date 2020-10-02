import javax.management.StringValueExp;

/**
 * Utility class to evaluate Infix and Postfix expressions
 * 
 * @author Yared Fikremariam
 *
 */

public class Notation {

	/**
	 * Convert an infix expression into a postfix expression
	 * 
	 * @param infix the infix expression in string format
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFormatException if the infix expression format is
	 *                                        invalid
	 */

	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {

		NotationStack<Character> stk = new NotationStack<Character>();
		NotationQueue<Character> que = new NotationQueue<Character>();
		char[] c = infix.replaceAll(" ", "").toCharArray();
		char top;

		try {
			for (int i = 0; i < c.length; i++) {

				if (!isBalanced(infix)) {
					throw new InvalidNotationFormatException();
				}

				if (Character.isDigit(c[i])) {
					que.enqueue(c[i]);

				}

				else if (operator(c[i])) {
					while (!stk.isEmpty() && precedence(c[i]) <= precedence(stk.top())) {
						que.enqueue(stk.top());
						stk.pop();
					}

					stk.push(c[i]);
				}

				else if (c[i] == '(') {
					stk.push(c[i]);
				}

				else if (c[i] == ')') {			

					top = stk.pop();
					while (top != '(' && !stk.isEmpty()) {
						que.enqueue(top);
						top = stk.pop();

					}
				}

			}

			while (!stk.isEmpty()) {
				top = stk.pop();
				que.enqueue(top);

			}

			return que.toString();

		}

		catch (StackOverflowException | QueueOverflowException | StackUnderflowException e) {
			e.printStackTrace();

		}

		return que.toString();
	}

	/**
	 * Convert the Postfix expression to the Infix expression
	 * 
	 * @param postfix the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException if the postfix expression format is
	 *                                        invalid
	 */

	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {

		NotationStack st = new NotationStack();
		NotationQueue<Character> qu = new NotationQueue<Character>();
		char[] c = postfix.replaceAll(" ", "").toCharArray();
		String str = "";

		try {
			for (int i = 0; i < c.length; i++) {
				if (Character.isDigit(c[i])) {
					st.push(c[i]);
				}

				else if (operator(c[i]) && st.size() >= 2) {
					str = ")" + st.pop().toString() + String.valueOf(c[i]) + st.pop().toString() + "(";
					st.push(str);
				}

				else if (st.size() < 2) {
					throw new InvalidNotationFormatException();
				}

			}

			if (st.size() > 1) {
				throw new InvalidNotationFormatException();
			}

		} catch (StackOverflowException | StackUnderflowException e) {
			e.printStackTrace();
		}

	
		StringBuilder stb = new StringBuilder(str);
		StringBuilder stbr = stb.reverse();
		return stbr.toString();

	}

	/**
	 * Evaluates a postfix expression from a string to a double
	 * 
	 * @param postfixExpr the postfix expression in String format
	 * @return the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException if the postfix expression format is
	 *                                        invalid
	 */

	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {

		NotationStack st = new NotationStack();
		char[] c = postfixExpr.replaceAll(" ", "").toCharArray();
		double result = 0;

		try {

			for (int i = 0; i < c.length; i++) {
				if (Character.isDigit(c[i]) || c[i] == '(') {
					st.push(c[i]);
				}

				else if (operator(c[i]) && st.size() >= 2) {
					double f = Double.parseDouble(String.valueOf(st.pop()));
					double s = Double.parseDouble(String.valueOf(st.pop()));
					switch (c[i]) {
					case '*':
						result = s * f;
						break;
					case '/':
						result = s / f;
						break;
					case '+':
						result = s + f;
						break;
					case '-':
						result = s - f;
						break;
					default:
						throw new InvalidNotationFormatException();
					}

					st.push(result);

				}

				else if (st.size() < 2) {
					throw new InvalidNotationFormatException();
				}
			}

			if (st.size() > 1) {
				throw new InvalidNotationFormatException();
			}

			return (double) st.pop();

		}

		catch (StackOverflowException | StackUnderflowException e) {
			e.printStackTrace();
		}

		if (st.size() > 1) {
			throw new InvalidNotationFormatException();
		}

		return result;

	}

	/**
	 * Evaluates a infixfix expression from a string to a double
	 * 
	 * @param infixExpr the infix expression in String format
	 * @return the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException if the infix expression format is
	 *                                        invalid
	 */

	public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException {

		String s = convertInfixToPostfix(infixExpr);

		return evaluatePostfixExpression(s);

	}

	/**
	 * Checks the precedence of operators
	 * 
	 * @param a character to be evaluated
	 * @return 0 if + or - and 1 if * or /
	 */

	private static int precedence(char a) {
		int r = -1;
		switch (a) {

		case '+':
		case '-':
			r = 0;
			break;
		case '*':
		case '/':
			r = 1;
			break;
		default:
			break;
		}

		return r;
	}

	/**
	 * Checks if a character is an operator
	 * 
	 * @param a the character to be checked
	 * @return true if character is operator, false otherwise
	 */

	private static boolean operator(char a) {
		if (a == '+' || a == '-' || a == '*' || a == '/') {
			return true;
		}
		return false;
	}

	
	/**
	 * Checks if the given expression is valid
	 * @param text Input string
	 * @return True if the expression is valid, false otherwise
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 */
	private static boolean isBalanced(String text) throws StackOverflowException, StackUnderflowException {

		NotationStack<Character> temp = new NotationStack<>();

		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) == '(')
				temp.push('(');

			else if (text.charAt(i) == ')') {
				if (temp.isEmpty())
					return false;
				if (temp.pop() != '(')
					return false;
			}

		}
		return temp.isEmpty();

	}

}
