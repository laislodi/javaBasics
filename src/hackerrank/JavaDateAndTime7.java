package hackerrank;


import java.util.Calendar;
import java.util.Scanner;

public class JavaDateAndTime7 {
    public static String getDay(String day, String month, String year) {
        String dayOfWeek = "";

        Calendar calendar = Calendar.getInstance();

        calendar.set(Integer.valueOf(year),Integer.valueOf(month) - 1,Integer.valueOf(day));
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1:
                dayOfWeek = "SUNDAY"; //Calendar.SUNDAY;
                break;
            case 2:
                dayOfWeek = "MONDAY";//Calendar.MONDAY;
                break;
            case 3:
                dayOfWeek = "TUESDAY";//Calendar.TUESDAY;
                break;
            case 4:
                dayOfWeek = "WEDNESDAY";//Calendar.WEDNESDAY;
                break;
            case 5:
                dayOfWeek = "THURSDAY"; //Calendar.THURSDAY;
                break;
            case 6:
                dayOfWeek = "FRIDAY";//Calendar.FRIDAY;
                break;
            case 7:
                dayOfWeek = "SATURDAY";//Calendar.SATURDAY;
                break;
        }

        return dayOfWeek;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }
}