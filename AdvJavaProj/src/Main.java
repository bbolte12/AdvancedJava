import java.util.Scanner;
import java.io.IOException;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		System.out.println("Please enter your username: ");
		username = scanner.next();
		
		System.out.println("Please enter your password: ");
		password = scanner.next();
		
		LogCheck.logCheck(username, password);
		scanner.close();
	}
}
//Project has been added to repository. 
