import java.util.*;

public class SimpleLogger {
	static ArrayList<String> logs = new ArrayList<String>();

	public static void addLog(String s) { //add method for log messages
		//add this string to the logs
		logs.add(s);
	}
	
	public static List<String> getLog() { 
		//retrieve all of the log entries
		return logs;
	}
}
