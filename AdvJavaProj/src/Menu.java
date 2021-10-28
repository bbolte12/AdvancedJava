import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
	
	public static void userSelect(int userInput) throws SQLException {
	
		System.out.println("Please select from the following options:");
		System.out.println("\n1: Buy" + "\n2: Sell" + "\n3: Exit");
		Scanner s = new Scanner(System.in);
		
		int MenuSel;
		MenuSel = s.nextInt();
		//Using switch case to present the user with a category selection
		switch(MenuSel) {
		case 1:	//Brings user to the buy menu to select category
			System.out.println("You have selected Buy(1), Please select a category to browse:");
			Categories.selCategory(userInput);
			break;
		
		case 2:	//Brings user to sale menu to choose what category to sell in
			System.out.println("You have selected Sell(2):");
			Categories.sellVeh(userInput);
			break;
		
		case 3:	//Exits program
			System.out.println("Thank you for visiting, goodbye");
			System.out.println("Logged Items");
			LogHandler.logHigh("Exited Program");//logs termination of program in logger
			for (String message: SimpleLogger.getLog()) {
				System.out.println(message);
			}			
			System.exit(0);
			break;
			
		default:	//Makes user try again if invalid entry
			System.out.println("Invalid Entry, Please Try Again");
			userSelect(userInput);
		}
		s.close();
	}
}