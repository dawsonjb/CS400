// --== CS400 File Header Information ==--
// Name: Dawson Bauer
// Email: djbauer2@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;

public class TestLogInAndRegister {
	
	public static void main (String args []) {
		testAddUser();
		testAddUserWithCapacity();
		testUserExists();
		testUserExistsFalse();
		testLogIn();
		testLogInFalse();
	}
	
	/**
	   * This method tests if a user with a specific capacity can 
	   * be added to the LogInAndRegister. This method uses the 
	   * addUser() method.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testAddUser() {
		LogInAndRegister test = new LogInAndRegister();
		if (!test.addUser("username", "password")) {
			System.out.println("addUser() failed. User was not added.");
			return false;
		} else {
			return true;
		}
	}
	/**
	   * This method tests if a user with a specific capacity can 
	   * be added to the LogInAndRegister. This method uses the 
	   * addUser(capacity) method.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testAddUserWithCapacity() {
		LogInAndRegister test = new LogInAndRegister();
		if (!test.addUser("username", "password", 20)) {
			System.out.println("addUser() failed. User was not added.");
			return false;
		} else {
			return true;
		}
	}
	/**
	   * This method tests if a user exists in the LogInAndRegister. 
	   * A user is added first and then runs the isUserExists method.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testUserExists() {
		LogInAndRegister test = new LogInAndRegister();
		test.addUser("username", "password");
		if (!test.userExists("username", "password")) {
			System.out.println("userExists() failed. User was not found.");
			return false;
		} else {
			return true;
		}
	}
	/**
	   *  This method tests when a user doesn'y exist in the LogInAndRegister. 
	   *  No user is added and then the method runs the isUserExists method.
	   *  The method should return no.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testUserExistsFalse() {
		LogInAndRegister test = new LogInAndRegister();
		if (test.userExists("username", "password")) {
			System.out.println("userExists() didn't fail but should have.");
			return false;
		} else {
			return true;
		}
	}
	/**
	   * This method tests if a user can log in with the correct username 
	   * and password. This method catches any NoSuchElementExceptions that 
	   * shouldn't be thrown.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testLogIn() {
		LogInAndRegister test = new LogInAndRegister();
		test.addUser("username", "password");
		try {
			test.logIn("username", "password");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("logIn() failed.");
			return false;
		}
	}
	/**
	   * This method tests if a user can log in with the incorrect username 
	   * and password.This method catches any NoSuchElementExceptions that 
	   * should be thrown.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testLogInFalse() {
		LogInAndRegister test = new LogInAndRegister();
		try {
			test.logIn("username", "password");
			System.out.println("logIn() should have fail but didn't.");
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}
	
}
