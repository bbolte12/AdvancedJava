import java.util.Scanner;
import java.io.IOException;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, SQLException {
		boolean name;
		boolean key;
		int userInput = 0;
		Scanner scanner = new Scanner(System.in);
		LogHandler.logHigh("started Program");//logs started program in logger
		
		System.out.println("Please enter username and password:\n");
	
		do {
			// sets username
			String userName = "Bob";
			String nameAttempt = scanner.next();

			name = ValidateUserInput.isValid(userName, nameAttempt);
			// If wrong username, display message
			if (!name) {
				System.out.println("That username does not exist, please try again or create an account\n");
				LogHandler.logLow("User incorrectly entered" + name);//logs incorrect login in logger, displays incorrect login used
			}
		} while (!name);
		do {
			// sets password
			String password = "F!sh";
			String passAttempt = scanner.next();

			key = ValidateUserInput.isValid(password, passAttempt);
			// If wrong password, display message
			if (!key) {
				System.out.println("Incorrect Password, please try again\n");
			}
		}
		while (!key);
		
		//connect to database
		try {
			String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
			@SuppressWarnings("unused")
			Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");
			System.out.println("Connection Successfull");	
			LogHandler.logLow("Connection Successfull");//logs connection successful in logger
		}
		catch (Exception e) {
			System.out.println("Error Connecting to the database: " + e.getMessage());
			LogHandler.logLow("Connection Unsuccessfull");//logs connection unsuccessful in logger
		}
			
		//displays menu for user selection
		Menu.userSelect(userInput);
		scanner.close();
	}
}
//Project has been added to repository
