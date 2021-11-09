import java.sql.*;
import java.util.Scanner;

public class LogCheck {

	static boolean logCheck() throws SQLException {
		
		System.out.println("~~~Hi, Welcome to my car sales program, please select from the following options~~~");
		System.out.println("\n1: login with existing account" + "\n2: Create an Account");
		
		int userInput = 0;
		boolean login = false;
		Scanner sc = new Scanner(System.in);
		String username;
		String password;
		int select;
		select = sc.nextInt();
		
		switch(select) {
		case 1:	//allows user to login with existing username and password
		try {
			System.out.println("~~~Please enter your username: ~~~");
			username = sc.next(); //assigns user input for username
			
			System.out.println("~~~Please enter your password: ~~~");
			password = sc.next(); //assigns user input for password
			
			String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
			Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");// connects to database

			String query = "SELECT * FROM users WHERE user_name = ? AND user_password = ?"; //searches users table for matching username and password
			PreparedStatement sql = connection.prepareStatement(query);
			sql.setString(1, username); //sets username as search criteria
			sql.setString(2, password); //sets password as search criteria
			ResultSet rs = sql.executeQuery();

			while (rs.next()) { //while loop for if entered info is correct or not
				String checkUser = rs.getString(1);
				String checkPass = rs.getString(2);

				if ((checkUser.equals(username)) && (checkPass.equals(password))) { //if both username and password match, the user can successfully login
					login = true;
					System.out.println("~~~Login Successful~~~");
					Menu.userSelect(userInput);

				} else { //if either the username or password are incorrect, login is failed
					login = false;
					System.out.println("~~~Incorrect username and/or password, please try again: ~~~");
					logCheck();
				}
			}
			connection.close();
		}

		catch (Exception err) {
			System.out.println("Error: " + err);
		}
		
		case 2: //used to create a new account
			String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
			Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");//database connection
			
			System.out.println("~~~Please enter your new username: ~~~");			
			String nUsername = sc.next(); //sets new username
		
			System.out.println("~~~Please enter your new password: ~~~");
			String nPassword = sc.next(); //sets new password
			
			String sql = "insert into users "
					+ "(user_name, user_password)" + "values (?, ?)";//SQL insert statement
			PreparedStatement myStmt = connection.prepareStatement(sql);
			
			myStmt.setString(1, nUsername);//sets new user_name in users table
			myStmt.setString(2, nPassword);//sets new user_password in users table
			
			myStmt.executeUpdate(); //updates table
			System.out.println("~~~Account Created Successfully~~~");
			logCheck(); //brings user back to login selection
			connection.close();
			sc.close();
		}
		return login;
		
	}
	
}
