package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;

/**
 * Created by FlorianDoublet on 30/10/2016.
 */
public class DateManipulation {

    public static Integer ELAPSED_DAYS = 1;
    public static Integer ELAPSED_HOURS = 2;
    public static Integer ELAPSED_MINUTES = 3;

    /**
     * Check if the Calendar given in param is tomorrow from the current date
     * @param cal
     * @return True or False
     */
    public static Boolean isTomorrow(Calendar cal){
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_MONTH,1);
        return cal.get(Calendar.DAY_OF_MONTH) == tomorrow.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Concert a date into a string (only for hours and minutes)
     * @param date
     * @return
     */
    public static String dateHourMinuteToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("H:mm", Locale.FRANCE);
        String date_s = null;
        try {
            date_s = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date_s;
    }

    /**
     * Method to get the difference between to calendar.
     * The difference order is the first Cal - the second Cal
     * @param cal1 usually the older calendar
     * @param cal2 the other calendar to compare
     * @return a hashTable of the result
     */
    public static Hashtable<Integer, Integer> diffBetweenTwoDate(Calendar cal1, Calendar cal2){

        Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
        Date cal1Date = cal1.getTime();
        Date cal2Date = cal2.getTime();


        //milliseconds
        long different = cal1Date.getTime() - cal2Date.getTime();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        int elapsedDays = (int) (different / daysInMilli);
        different = different % daysInMilli;

        int elapsedHours = (int) (different / hoursInMilli);
        different = different % hoursInMilli;

        int elapsedMinutes = (int) (different / minutesInMilli);
        different = different % minutesInMilli;

        hashTable.put(ELAPSED_DAYS,elapsedDays);
        hashTable.put(ELAPSED_HOURS,elapsedHours);
        hashTable.put(ELAPSED_MINUTES,elapsedMinutes);

        return hashTable;
    }
}