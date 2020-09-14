import java.util.ArrayList;
import java.util.regex.*;

/**
 * Password Checker Utility
 * 
 * @author Yared Fikremariam
 *
 */

public class PasswordCheckerUtility {

	/**
	 * Return true if valid password (follows all the rules ). Throws exceptions for
	 * invalid passwords.
	 * 
	 * @param passwordString String to be checked
	 * @return True if password is valid
	 * @throws LengthException          thrown if length is less than 6 characters
	 * @throws NoUpperAlphaException    thrown if no uppercase character
	 * @throws NoLowerAlphaException    thrown if no lowercase cahracter
	 * @throws NoDigitException         thrown if no digit
	 * @throws NoSpecialSymbolException thrown if no special character
	 * @throws InvalidSequenceException thrown if there are more than two identical
	 *                                  consecutive characters
	 */
	public static boolean isValidPassword(String passwordString) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialSymbolException, InvalidSequenceException {

		length(passwordString);
		upperCase(passwordString);
		lowerCase(passwordString);
		numericCtr(passwordString);
		specialCtr(passwordString);
		repeatSeq(passwordString);

		return true;
	}

	/**
	 * Return false if the password is not weak, throws exception if so
	 * 
	 * @param passwordString String to be checked
	 * @return false if password is not weak
	 * @throws WeakPasswordException thrown if password is between 6 and 10
	 *                               characters
	 */
	public static boolean isWeakPassword(String passwordString) throws WeakPasswordException {

		if (passwordString.length() >= 6 && passwordString.length() <= 9) {
			throw new WeakPasswordException();
		} else
			return false;
	}

	/**
	 * Takes in an ArrayList of passwords and returns ArrayList of invalid passwords
	 * 
	 * @param passwords ArrayList to be checked
	 * @return ArrayList invalidPasswords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList passwords) {

		ArrayList<String> invalidPasswords = new ArrayList<String>();

		for (int i = 0; i < passwords.size(); i++) {

			try {
				isValidPassword((String) passwords.get(i));
				isWeakPassword((String) passwords.get(i));
			}

			catch (Exception e) {
				String s = "";
				s += (String) passwords.get(i) + " ->" + e.getMessage();

				invalidPasswords.add(s);

			}
		}

		return invalidPasswords;
	}

	/**
	 * Checks length
	 * 
	 * @param passwordString
	 * @return true if password is more than 6 characters
	 * @throws LengthException
	 */
	private static boolean length(String passwordString) throws LengthException {
		if (passwordString.length() < 6) {
			throw new LengthException();
		} else
			return true;
	}

	/**
	 * Checks for UpperCase
	 * 
	 * @param passwordString
	 * @return
	 * @throws NoUpperAlphaException
	 */
	private static boolean upperCase(String passwordString) throws NoUpperAlphaException {
		Pattern p = Pattern.compile("(?=.*[A-Z])");
		Matcher m = p.matcher(passwordString);

		if (!m.find()) {
			throw new NoUpperAlphaException();
		}

		else
			return true;
	}

	/**
	 * Checks LowerCase
	 * 
	 * @param passwordString
	 * @return
	 * @throws NoLowerAlphaException
	 */
	private static boolean lowerCase(String passwordString) throws NoLowerAlphaException {
		Pattern p = Pattern.compile("(?=.*[a-z])");
		Matcher m = p.matcher(passwordString);

		if (!m.find()) {
			throw new NoLowerAlphaException();
		}

		else
			return true;
	}

	/**
	 * Checks for digits
	 * 
	 * @param passwordString
	 * @return
	 * @throws NoDigitException
	 */
	private static boolean numericCtr(String passwordString) throws NoDigitException {
		Pattern p = Pattern.compile("(?=.*[0-9])");
		Matcher m = p.matcher(passwordString);

		if (!m.find()) {
			throw new NoDigitException();
		}

		else
			return true;
	}

	/**
	 * Checks for special characters
	 * 
	 * @param passwordString
	 * @return
	 * @throws NoSpecialSymbolException
	 */
	private static boolean specialCtr(String passwordString) throws NoSpecialSymbolException {
		Pattern p = Pattern.compile("(?=.*[!@#$%^&*])");
		Matcher m = p.matcher(passwordString);

		if (!m.find()) {
			throw new NoSpecialSymbolException();
		}

		else
			return true;
	}

	/**
	 * Checks for repeated sequences
	 * 
	 * @param passwordString
	 * @return
	 * @throws InvalidSequenceException
	 */
	private static boolean repeatSeq(String passwordString) throws InvalidSequenceException {
		char a, b, c;
		for (int i = 2; i < passwordString.length(); i++) {
			a = passwordString.charAt(i - 2);
			b = passwordString.charAt(i - 1);
			c = passwordString.charAt(i);

			if (a == b && b == c) {
				throw new InvalidSequenceException();

			}

		}
		return true;
	}
}
