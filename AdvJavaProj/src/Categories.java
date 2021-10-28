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
			System.out.println("~~~Cars will be displayed Make, Model, Year");
			
			try {
				String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
				Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");//connects to database
				
				PreparedStatement sql = connection.prepareStatement("Select * from cars");//select statement to show
				ResultSet rs = sql.executeQuery();											//cars table
				
				while(rs.next()) {
					String manName = rs.getString("manufacture_name");
					String modName = rs.getString("model_name");
					String year = rs.getString("year");
						
					System.out.println(manName + " " + modName + " " + year);//displays cars table
				}
			}
			catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
			Menu.userSelect(userInput);//brings user back to main menu
			break;
		
		case 2:	//Shows trucks for sale
			System.out.println("~~~Trucks will be displayed Make, Model, Year");
			
			try {
				String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
				Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");//connects to database
				
				PreparedStatement sql = connection.prepareStatement("Select * from trucks");//select statement to show
				
				ResultSet rs = sql.executeQuery();											//trucks table
				
				while(rs.next()) {
					String manName = rs.getString("manufacture_name");
					String modName = rs.getString("model_name");
					String year = rs.getString("year");
						
					System.out.println(manName + " " + modName + " " + year);//displays trucks table
				}
			}
			catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
			Menu.userSelect(userInput);//brings user back to main menu
			break;
		
		case 3:	//Shows both cars and trucks for sale
			System.out.println("~~~Vehicals will be displayed Make, Model, Year");
			
			try {
				String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";	
				Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");//connects to database
				
				PreparedStatement sql = connection.prepareStatement("Select * from cars");//select statement for cars table
				PreparedStatement sql2 = connection.prepareStatement("Select * from trucks");//select statement for trucks table
				
				ResultSet rs = sql.executeQuery();
				ResultSet rs2 = sql2.executeQuery();
				
				while(rs.next()) {
					String manName = rs.getString("manufacture_name");
					String modName = rs.getString("model_name");
					String year = rs.getString("year");
						
					System.out.println(manName + " " + modName + " " + year);//displays cars table
				}
				while(rs2.next()) {
					String manName = rs2.getString("manufacture_name");
					String modName = rs2.getString("model_name");
					String year = rs2.getString("year");
						
					System.out.println(manName + " " + modName + " " + year);//displays trucks table
				}
			}
			catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
			Menu.userSelect(userInput);//brings user back to main menu
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
		
		System.out.println("Please select either:" + "\n1: Car" + "\n2: Truck");
		Scanner sc = new Scanner(System.in);
		int sel;
		sel = sc.nextInt();
			
		switch(sel) {
		case 1:	//Prompts user to enter the car as make-model, then adds userinput to database
			
				String urlConn = "jdbc:mysql://localhost:3306/advjavaproj";
				Connection connection = DriverManager.getConnection(urlConn, "root", "Bb41907410@$");//database connection
				
				System.out.println("~~~Please enter the car make: ~~~");			
				String make = sc.next();
			
				System.out.println("~~~Please enter the car model: ~~~");
				String model = sc.next();
			
				System.out.println("~~~Please enter the car year: ~~~");
				String year = sc.next();
				
				String sql = "insert into cars "
						+ "(manufacture_name, model_name, year)" + "values (?, ?, ?)";//SQL insert statement
				PreparedStatement myStmt = connection.prepareStatement(sql);
				
				myStmt.setString(1, make);//sets manufacure_name value
				myStmt.setString(2, model);//sets model_name value
				myStmt.setString(3, year);//sets year value
				
				myStmt.executeUpdate();//executes statement, updates table
			
				System.out.println("~~~Car Successfully Added~~~");
				System.out.println("~~~Returning To Menu~~~");
				Menu.userSelect(userInput);	//Returns user to main menu
			break;
			
		case 2:	//Prompts user to enter the truck as make-model, then adds userinput to trucks arraylist
			String urlConn2 = "jdbc:mysql://localhost:3306/advjavaproj";
			Connection connection2 = DriverManager.getConnection(urlConn2, "root", "Bb41907410@$");//database connection
			
			System.out.println("~~~Please enter the truck make: ~~~");			
			String truckMake = sc.next();
		
			System.out.println("~~~Please enter the truck model: ~~~");
			String truckModel = sc.next();
		
			System.out.println("~~~Please enter the truck year: ~~~");
			String truckYear = sc.next();
			
			String sql2 = "insert into trucks "
					+ "(manufacture_name, model_name, year)" + "values (?, ?, ?)";
			PreparedStatement myStmt2 = connection2.prepareStatement(sql2);
			
			myStmt2.setString(1, truckMake);//sets manufacture_name value
			myStmt2.setString(2, truckModel);//sets model_name value
			myStmt2.setString(3, truckYear);//sets year value
			
			myStmt2.executeUpdate();//executes statement, updates table
		
			System.out.println("~~~Truck Successfully Added~~~");
			System.out.println("~~~Returning To Menu~~~");
			Menu.userSelect(userInput);	//Returns user to main menu
			break;
			
		default:
			System.out.println("Invalid Entry, Please Try Again");//makes user try selection again if invalid entry
			sellVeh(userInput);
			}
		sc.close();
		}
	}


