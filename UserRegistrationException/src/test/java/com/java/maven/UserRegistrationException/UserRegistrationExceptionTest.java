package com.java.maven.UserRegistrationException;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class UserRegistrationExceptionTest
{
	private UserRegistrationException validator;

	@Before
	public void init() {
		validator = new UserRegistrationException();
	}

	@Test
	public void FirstNameCorrect() {
		try {
			boolean isValid = validator.validateFirstName("Rachit");
			assertEquals(true, isValid);
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void FirstNameIncorrect() {
		try {
			validator.validateFirstName("Rachit$");
		} catch (InvalidUserDetailsException e) {
			assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_FIRST_NAME, e.type);
		}
	}


	@Test
	public void LastNameCorrect() {
		try {
			boolean isValid = validator.validateLastName("Shukla");
			assertEquals(true, isValid);
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void LastNameIncorrect() {
		try {
			validator.validateLastName("shukla");
		} catch (InvalidUserDetailsException e) {
			assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_LAST_NAME, e.type);
		}
	}



	@Test
	public void MobileNumberCorrect() {
		try {
			boolean isValid = validator.validateMobile("91 9876543210");
			assertEquals(true, isValid);
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void MobileNumberIncorrect() {
		try {
			validator.validateMobile("1 98765");
		} catch (InvalidUserDetailsException e) {
			assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_MOBILE, e.type);
		}
	}
	// Tests for mobile number

	@Test
	public void EmailCorrect() {
		try {
			boolean isValid = validator.validateEmail("abc@yahoo.com");
			assertEquals(true, isValid);
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void EmailIncorrect() {
		try {
			validator.validateEmail(".100@abc.com.au");
		} catch (InvalidUserDetailsException e) {
			assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_EMAIL, e.type);
		}
	}


	@Test
	public void PasswordCorrect() {
		try {
			boolean isValid =validator.validatePassword("aBcd123@m");
			assertEquals(true, isValid);
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void PasswordIncorrect() {
		try {
			validator.validatePassword("ABC12345");
		} catch (InvalidUserDetailsException e) {
			assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_PASSWORD, e.type);
		}
	}
}
