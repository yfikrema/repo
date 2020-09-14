
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @Yared Fikremariam
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;

	@Before
	public void setUp() throws Exception {
		String[] p = { "1@Qwegrn&%d", "1@QWEGRN&%D", "#Rt7jf%cjh", "1@qwegrn&%d", "2$&Tgfdfg8Y", "t@Qwegrn&%d",
				"$Thj7klgdfgh", "1@Q%d", "1r@Qwegrngud", "1rQwegrngud", "$T6fsdjfvdfl", "1@QQQwegrn&%d", "1@Qwn&%dT%u",
				"1@Qwn&d" };

				passwords = new ArrayList<String>();
				passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test if the password is less than 8 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Qwe2#dr"));
			PasswordCheckerUtility.isValidPassword("Qwe2#");
			assertTrue("Did not throw LengthException", false);
		} catch (LengthException e) {
			assertTrue("LengthException", true);
		} catch (Exception e) {
			assertTrue("Other Exception", false);
		}
	}

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {

			assertTrue(PasswordCheckerUtility.isValidPassword("Qwe2#dr"));
			PasswordCheckerUtility.isValidPassword("qwe2#dr");
			assertTrue("Did not throw NoUpperAlphaException", false);
		} catch (NoUpperAlphaException e) {
			assertTrue("NoUpperAlphaException", true);
		} catch (Exception e) {
			assertTrue("Other Exception", false);
		}
	}

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Qwe2#dr"));
			PasswordCheckerUtility.isValidPassword("QWE2#41");
			assertTrue("Did not throw NoLowerAlphaException", false);
		} catch (NoLowerAlphaException e) {
			assertTrue("NoLowerAlphaException", true);
		} catch (Exception e) {
			assertTrue("Other Exception", false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("Qwe2#dr"));
			PasswordCheckerUtility.isWeakPassword("QWE2#41");
			assertTrue("Did not throw WeakPasswordException", false);
		} catch (WeakPasswordException e) {
			assertTrue("WeakPasswordException", true);
		} catch (Exception e) {
			assertTrue("Other Exception", false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Qwe2#dr"));
			PasswordCheckerUtility.isValidPassword("QQQd2#41");
			assertTrue("Did not throw InvalidSequenceException", false);
		} catch (InvalidSequenceException e) {
			assertTrue("InvalidSequenceException", true);
		} catch (Exception e) {
			assertTrue("Other Exception", false);
		}
	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Qwe2#dr"));
			PasswordCheckerUtility.isValidPassword("Qrsi#gd");
			assertTrue("Did not throw NoDigitException", false);
		} catch (NoDigitException e) {
			assertTrue("NoDigitException", true);
		} catch (Exception e) {
			assertTrue("Other Exception", false);
		}
	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("1@Qwegrn&%d"));

		}

		catch (Exception e) {
			assertTrue("Threw Exception", false);
		}
	}

	/**
	 * Test the invalidPasswords method Check the results of the ArrayList of
	 * Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {

		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		Scanner scan = new Scanner(results.get(0)); 

		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));// Throws NoLowerCaseAlphaException

		scan = new Scanner(results.get(1));
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));// Throws NoUpperCaseAlphaException

		scan = new Scanner(results.get(2));
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));// Throws NoDigitException

		scan = new Scanner(results.get(3));
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("6"));// Throws LengthException

		scan = new Scanner(results.get(4));
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special"));// Throws NoSpecialCharacterException

		scan = new Scanner(results.get(5));
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence"));// Throws InvalidSequenceException

		scan = new Scanner(results.get(6));
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("weak")); // Throws WeakPasswordException

	}

}
