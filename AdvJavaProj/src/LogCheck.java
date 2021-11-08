import java.sql.*;

public class LogCheck {

	static boolean logCheck(String username, String password) {

		int userInput = 0;
		String query;
		boolean login = false;

		try {
			String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
			Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");// connects to database

			query = "SELECT * FROM users WHERE user_name = ? AND user_password = ?";
			PreparedStatement sql = connection.prepareStatement(query);
			sql.setString(1, username);
			sql.setString(2, password);
			ResultSet rs = sql.executeQuery();

			while (rs.next()) {
				String checkUser = rs.getString(1);
				String checkPass = rs.getString(2);

				if ((checkUser.equals(username)) && (checkPass.equals(password))) {
					login = true;
					System.out.println("~~~Login Successful~~~");
					Menu.userSelect(userInput);

				} else {
					login = false;
					System.out.println("~~~Incorrect username and/or password, please try again: ~~~");
					logCheck(username, password);
				}
			}
			connection.close();
		}

		catch (Exception err) {
			System.out.println("Error: " + err);
		}
		return login;
	}
}
