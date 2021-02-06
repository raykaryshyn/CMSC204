import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;


/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author Raymond Karyshyn
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwordsArray;

	@Before
	public void setUp() throws Exception {
		String[] p = {"123ABC^", "aaAA*1", "testing1", "mypassword*123ABC", "password", "Ssssss6%", "123", "BgtF8^!"};
		passwordsArray = new ArrayList<String>();
		passwordsArray.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		passwordsArray = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		// Test "123", which should throw a LengthException
		Throwable exception = assertThrows(LengthException.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidLength(passwordsArray.get(6));
			}
		});		
		assertEquals("The password must be at least 6 characters long", exception.getMessage());

		// Test "Ssssss6%", which should not throw an exception and return "True"
		try {
			assertTrue(PasswordCheckerUtility.isValidLength(passwordsArray.get(5)));
		}
		catch (LengthException e) {
			fail("This password was supposed to pass length requirements.");
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		// Test "password", which should throw a NoUpperAlphaException
		Throwable exception = assertThrows(NoUpperAlphaException.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasUpperAlpha(passwordsArray.get(4));
			}
		});		
		assertEquals("The password must contain at least one uppercase alphabetic character", exception.getMessage());

		// Test "123ABC^", which should not throw an exception and return "True"
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(passwordsArray.get(0)));
		}
		catch (NoUpperAlphaException e) {
			fail("This password was supposed to pass upper alpha requirements.");
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		// Test "123ABC^", which should throw a NoLowerAlphaException
		Throwable exception = assertThrows(NoLowerAlphaException.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasLowerAlpha(passwordsArray.get(0));
			}
		});		
		assertEquals("The password must contain at least one lowercase alphabetic character", exception.getMessage());

		// Test "password", which should not throw an exception and return "True"
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(passwordsArray.get(4)));
		}
		catch (NoLowerAlphaException e) {
			fail("This password was supposed to pass lower alpha requirements.");
		}
	}
	/**
	 * Test if the password is valid and has more than 9 characters
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		// Test "aaAA*1", which should throw a WeakPasswordException
		Throwable exception = assertThrows(WeakPasswordException.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isWeakPassword(passwordsArray.get(1));
			}
		});		
		assertEquals("The password is OK but weak - it contains fewer than 10 characters", exception.getMessage());

		// Test "mypassword*123ABC", which should not throw an exception and return "False"
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(passwordsArray.get(3)));
		}
		catch (WeakPasswordException e) {
			fail("This password was supposed to pass lower alpha requirements.");
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		// Test "Ssssss6%", which should throw a InvalidSequenceException
		Throwable exception = assertThrows(InvalidSequenceException.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSameCharInSequence(passwordsArray.get(5));
			}
		});		
		assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());

		// Test "mypassword*123ABC", which should not throw an exception and return "True"
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence(passwordsArray.get(3)));
		}
		catch (InvalidSequenceException e) {
			fail("This password was supposed to pass sequence requirements.");
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		// Test "password", which should throw a NoDigitException
		Throwable exception = assertThrows(NoDigitException.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasDigit(passwordsArray.get(4));
			}
		});		
		assertEquals("The password must contain at least one digit", exception.getMessage());

		// Test "testing1", which should not throw an exception and return "True"
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(passwordsArray.get(2)));
		}
		catch (NoDigitException e) {
			fail("This password was supposed to pass digit requirements.");
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		// Test "testing1", which should not throw an exception and return "True"
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwordsArray.get(1)));
			assertTrue(PasswordCheckerUtility.isValidPassword(passwordsArray.get(3)));
			assertTrue(PasswordCheckerUtility.isValidPassword(passwordsArray.get(7)));
		}
		catch (Exception e) {
			fail("All passwords were supposed to be valid.");
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwordsArray);

		assertEquals(results.size(), 5);
		assertEquals(results.get(0), "123ABC^ -> The password must contain at least one lowercase alphabetic character");
		assertEquals(results.get(1), "testing1 -> The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(2), "password -> The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(3), "Ssssss6% -> The password cannot contain more than two of the same character in sequence");
		assertEquals(results.get(4), "123 -> The password must be at least 6 characters long");
	}
}
