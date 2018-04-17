package school.datautil;

import javafx.util.converter.LocalDateStringConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

    public static String localDateToString(LocalDate localDate){
        return localDate.getDayOfMonth()
                + "/" + (localDate.getMonthValue() + 1)
                + "/" + localDate.getYear();
    }

    public static LocalDate stringToLocalDate(String data){
        LocalDate localDate = null;
        if (data.length() == 10) { // DD/MM/YYYY
            LocalDateStringConverter stringConverter = new LocalDateStringConverter();
            localDate = stringConverter.fromString(data);
        }
        return localDate;
    }

    public static String calendarToString(Calendar calendar){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String data = format.format(calendar.getTime());

        return data;
    }

    public static Calendar stringToCalendar(String data){
        Calendar calendar = Calendar.getInstance();
        Date parse;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            parse = format.parse(data);
            calendar.setTime(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

}
