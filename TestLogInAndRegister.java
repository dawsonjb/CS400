import java.util.NoSuchElementException;

public class TestLogInAndRegister {

	public static boolean testAddUser() {
		LogInAndRegister test = new LogInAndRegister();
		//tests database put() and constructor
		if (test.addUser("username", "password") == false) {
			System.out.println("addUser() failed. User was not added.");
			return false;
		} else {
			return true;
		}
	}
	public static boolean testAddUserWithCapacity() {
		LogInAndRegister test = new LogInAndRegister();
		//tests database put() and constructor
		if (test.addUser("username", "password", 20) == false) {
			System.out.println("addUser() failed. User was not added.");
			return false;
		} else {
			return true;
		}
	}
	public static boolean testUserExists() {
		LogInAndRegister test = new LogInAndRegister();
		test.addUser("username", "password");
		if (test.userExists("username", "password") == false) {
			System.out.println("userExists() failed. User was not found.");
			return false;
		} else {
			return true;
		}
	}
	public static boolean testUserExistsFalse() {
		LogInAndRegister test = new LogInAndRegister();
		if (test.userExists("username", "password") == true) {
			System.out.println("userExists() didn't fail but should have.");
			return false;
		} else {
			return true;
		}
	}
	public static boolean testLogIn () {
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
	public static boolean testLogInFalse () {
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