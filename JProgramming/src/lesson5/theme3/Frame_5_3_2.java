package lesson5.theme3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Frame_5_3_2 {

    public static void main(String[] args) throws ParseException {

        Date today = new Date();
        System.out.println(today);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyy");
        System.out.println(sdf.format(today));

        Date date = sdf.parse("10 Jul 2007");
        System.out.println(date);
    }
}

