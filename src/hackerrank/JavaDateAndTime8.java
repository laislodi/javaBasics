package hackerrank;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class JavaDateAndTime8 {
    public static String getDay(String day, String month, String year) {
        LocalDate date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }
}