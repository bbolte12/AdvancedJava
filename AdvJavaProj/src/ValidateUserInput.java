import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUserInput {
	//Checks to make sure password follows security standard
	//Contains lowercase, uppercase, punctuation, and number
	public static void correctInput(String[] args) {
		//sets password
		String password = "FancyW@sh3r";
		//uses Java regrex to check password for requirements
		String regExp = "^(?=.*[a-z])(?=."
					+ "*[A-Z])(?=.*\\d)"
					+ "(?=.*[!@#$?])"
					+ ".{8,12}$";
		boolean CorrectPassword = isValid(password, regExp);
		System.out.println("Password " + CorrectPassword + " is correct");
		}
	public static boolean isValid(String password, String regExp) {
		
		Pattern a = Pattern.compile(regExp);
		Matcher b = a.matcher(password);
		
		return b.matches();
	}
}