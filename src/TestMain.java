import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class TestMain {
    public static void main(String[] args) {
        Timestamp timestamp = Timestamp.valueOf("2024-05-19 20:00:00");
        String formattedDate = convertTimestampToString(timestamp);
        System.out.println(formattedDate); // Output: 19th May, 2024, 20:00
    }
    
    // Method to get the day of the week
    public static String getDayOfWeek(Timestamp t) {
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");
        return dayFormat.format(t);
    }

    // Method to get the day of the month
    public static String getDayOfMonth(Timestamp t) {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        return dayFormat.format(t);
    }
    
    public static String convertTimestampToString(Timestamp timestamp) {
        // Create a SimpleDateFormat instance with the desired format
        SimpleDateFormat sdf = new SimpleDateFormat("dd'th' MMMM, yyyy, HH:mm", Locale.ENGLISH);
        
        // Convert the timestamp to a date string
        String formattedDate = sdf.format(timestamp);
        
        // Handling the suffix for the day (st, nd, rd, th)
        int day = Integer.parseInt(new SimpleDateFormat("dd").format(timestamp));
        String daySuffix;
        
        switch (day % 10) {
            case 1:
                daySuffix = (day == 11) ? "th" : "st";
                break;
            case 2:
                daySuffix = (day == 12) ? "th" : "nd";
                break;
            case 3:
                daySuffix = (day == 13) ? "th" : "rd";
                break;
            default:
                daySuffix = "th";
        }
        
        // Replacing the placeholder suffix with the correct one
        formattedDate = formattedDate.replace("th", daySuffix);
        
        return formattedDate;
    }
}
