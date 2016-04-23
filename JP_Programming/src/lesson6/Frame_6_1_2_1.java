package lesson6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by prulov on 23.04.2016.
 */
public class Frame_6_1_2_1 {

    public static void main(String[] args) throws ParseException {

        Date today = new Date();
        System.out.println(today);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyy");
        System.out.println(sdf.format(today));

        Date date = sdf.parse("10 Jul 2007");
        System.out.println(date);
    }
}
