import java.util.Scanner;
import java.sql.*;

public class Purchase {

	public static void buyVehicle(int userInput) throws SQLException {
		
		System.out.println("\n~~~Would you like to purchase a vehicle?~~~");
		System.out.println("\n1: Yes" + "\n2: No");
		Scanner sc = new Scanner(System.in);

		int MenuSel;
		MenuSel = sc.nextInt();

		switch (MenuSel) {
		case 1: // Navigates user through purchasing a vehicle

			String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
			Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");// database connection

			System.out.println("~~~Please enter the Id# of the Vehicle you wish to buy~~~");
			String id = sc.next();

			System.out.println("~~~You have entered vehicle id#:" + id + "~~~");
			System.out.println("~~~Are you sure you want to purchase this vehicle yes/no?~~~");
			
			String ch = sc.next();
			if (ch.equalsIgnoreCase("yes")) {
				System.out.println("~~~Purchasing Vehicle~~~");

				String sql = "delete from vehicles where idvehicles ='" + id + "'"; // SQL insert statement
				PreparedStatement myStmt = connection.prepareStatement(sql);
				myStmt.executeUpdate();

				System.out.println("~~~Congratulations On Your Purchase!~~~");
				System.out.println("~~~Returning to Main Menu~~~");
				Menu.userSelect(userInput);
			} 
			
			else {
				System.out.println("~~~You have choosen not to buy the vehicle, returning to main menu~~~");
				Menu.userSelect(userInput);
			}
			break;

		case 2: // User selected no, returns user to main menu
			System.out.println("~~~You have selected No~~~");
			System.out.println("~~~Returning to main menu~~~");
			Menu.userSelect(userInput);
			break;

		default: // Makes user try again if invalid entry
			System.out.println("~~~Invalid Entry, Please Try Again~~~");
			buyVehicle(userInput);
		}
		sc.close();
	}

}
