
public class LogHandler {
	
	private static boolean logHigh = true;
	private static boolean logLow = true;

	public static void logHigh(String message) { //categorizes log message as high
		if (logHigh) {
			SimpleLogger.addLog(LogFormatter.formatHigh(message));
			
		}	
	}
	
	public static void logLow(String message) { //categorizes log message as low
		if (logLow) {
			SimpleLogger.addLog(LogFormatter.formatLow(message));
		}
	}
}
