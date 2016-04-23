package lesson6;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Frame_6_1_2 {

    public static void main(String[] args) {
        Date currentDate = new Date(237348277671l);
        SimpleDateFormat dateFormat = null;

        dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        System.err.println(dateFormat.format( currentDate ) );
    }
}
