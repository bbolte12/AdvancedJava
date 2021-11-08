import java.util.Scanner;
import java.sql.*;

public class Categories {
	
	public static void selCategory(int userInput) throws SQLException {	//Buy menu
		//Presents user with different categories to browse
		System.out.println("\n1: Cars" + "\n2: Trucks" + "\n3: All items" + "\n4: back to previous menu");
		
		Scanner sc = new Scanner(System.in);
		
		int select;
		select = sc.nextInt();
		
		switch(select) {
		case 1:	//Shows cars for sale
			System.out.println("\n~~~Cars will be displayed Id#, Make, Model, Year, vehicle type, price\n");
			
			try {
				String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
				Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");//connects to database
				
				PreparedStatement sql = connection.prepareStatement("Select * from vehicles where vehicle_type = 'car'");//select statement to show
				ResultSet rs = sql.executeQuery();											//cars table
				
				while(rs.next()) {
					String id = rs.getString("idvehicles");
					String manName = rs.getString("manufacture_name");
					String modName = rs.getString("model_name");
					String year = rs.getString("year");
					String type = rs.getString("vehicle_type");
					String price = rs.getString("price");
						
					System.out.println(id + " " + manName + " " + modName + " " + year + " " + type + " " + price);//displays cars table
				}
			}
			catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
			Purchase.buyVehicle(userInput);
			break;
		
		case 2:	//Shows trucks for sale
			System.out.println("\n~~~Trucks will be displayed Id#, Make, Model, Year vehicle type, price\n");
			
			try {
				String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
				Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");//connects to database
				
				PreparedStatement sql = connection.prepareStatement("Select * from vehicles where vehicle_type = 'truck'");//select statement to show
				
				ResultSet rs = sql.executeQuery();											//trucks table
				
				while(rs.next()) {
					String id = rs.getString("idvehicles");
					String manName = rs.getString("manufacture_name");
					String modName = rs.getString("model_name");
					String year = rs.getString("year");
					String type = rs.getString("vehicle_type");
					String price = rs.getString("price");
						
					System.out.println(id + " " + manName + " " + modName + " " + year + " " + type + " " + price);//displays trucks table
				}
			}
			catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
			Purchase.buyVehicle(userInput);
			break;
		
		case 3:	//Shows both cars and trucks for sale
			System.out.println("\n~~~Vehicals will be displayed Id#, Make, Model, Year, vehicle type, price\n");
			
			try {
				String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";	
				Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");//connects to database
				
				PreparedStatement sql = connection.prepareStatement("Select * from vehicles");//select statement for cars table
				
				ResultSet rs = sql.executeQuery();
				
				while(rs.next()) {
					String id = rs.getString("idvehicles");
					String manName = rs.getString("manufacture_name");
					String modName = rs.getString("model_name");
					String year = rs.getString("year");
					String type = rs.getString("vehicle_type");
					String price = rs.getString("price");
						
					System.out.println(id + " " + manName + " " + modName + " " + year + " " + type + " " + price);//displays cars table
				}
	
			}
			catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
			Purchase.buyVehicle(userInput);
			break;
			
		case 4:	//Goes back to previous menu
			System.out.println("~~~You have selected to go back~~~");
			Menu.userSelect(userInput);
			break;
			
		default:
			System.out.println("Invalid Entry, Please Try Again");//makes user try selection again if invalid entry
			selCategory(userInput);
		}
		sc.close();
	}
	
	public static void sellVeh(int userInput) throws SQLException {	//Sales menu
		
		System.out.println("~~~Please enter the requested information~~~");
		System.out.println("~~~ use a - for spaces~~~");
		Scanner sc = new Scanner(System.in);
			
				String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
				Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");//database connection
				
				System.out.println("~~~Please enter the vehicle make: ~~~");			
				String make = sc.next();
			
				System.out.println("~~~Please enter the vehicle model: ~~~");
				String model = sc.next();
				
				System.out.println("~~~Please enter the vehicle type, car or truck: ~~~");
				String type = sc.next();
			
				System.out.println("~~~Please enter the vehicle year: (4 digit format)~~~");
				String year = sc.next();
				
				System.out.println("~~~Please enter the vehicle price: (1234.00 format)~~~~");
				String price = sc.next();
				
				String sql = "insert into vehicles "
						+ "(manufacture_name, model_name, vehicle_type, year, price)" + "values (?, ?, ?, ?, ?)";//SQL insert statement
				PreparedStatement myStmt = connection.prepareStatement(sql);
				
				myStmt.setString(1, make);//sets manufacure_name value
				myStmt.setString(2, model);//sets model_name value
				myStmt.setString(3, type);//sets vehicle_type 
				myStmt.setString(4, year);//sets year value
				myStmt.setString(5, price);//sets vehicle price
				
				myStmt.executeUpdate();//executes statement, updates table
			
				System.out.println("~~~Vehicle Successfully Added~~~");
				System.out.println("~~~Returning To Menu~~~");
				Menu.userSelect(userInput);	//Returns user to main menu

		sc.close();
		}
	}//Added to repository


