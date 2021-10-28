import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

	public static String formatHigh(String logMessage) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); //formats high rank log messages
		return sdf.format(new Date()) + " High " + logMessage;
	}
	
	public static String formatLow(String logMessage) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); //formats low rank log messages
		return sdf.format(new Date()) + " Low " + logMessage;
	}
}
