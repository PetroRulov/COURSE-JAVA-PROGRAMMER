package lesson6;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.WEEK_OF_YEAR;

public class Frame_6_1_2 {

    public static void main(String[] args) throws ParseException {

        Date birthDate = new Date(237348277671l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        System.err.println(dateFormat.format(birthDate) );

        Calendar c = new GregorianCalendar();
        SimpleDateFormat format_1 = new SimpleDateFormat("dd.MM.yyyy");
        Date birthDay = format_1.parse("10.07.1977");
        c.setTime(birthDay);
        SimpleDateFormat dayOfWeek = new SimpleDateFormat("EEEE");
        System.out.println("In Russian: " + dayOfWeek.format(birthDay));
        System.out.println("In Russian: " + c.getDisplayName(7, 1, Locale.forLanguageTag("ru")));
        System.out.println("Im Deutsch: " + c.getDisplayName(7, 2, Locale.forLanguageTag("de")));
        System.out.println("In English: " + c.getDisplayName(7, 3, Locale.forLanguageTag("en")));

    }

}
