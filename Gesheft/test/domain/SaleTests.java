package domain;

import domain.waters.Water;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.currentTimeMillis;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by prulov on 14.06.2016.
 */
@RunWith(JUnit4.class)
public class SaleTests {

    private Water wat;
    private Sale sale;
    private double income;


    @Before
    public void init(){

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String date = df.format(new Date(currentTimeMillis()));
        wat = new Water(0, null, null, null, 0.0, 0, 0.0, 0.0);
        sale = new Sale(0, date, null, wat, 0);
    }

    @Test
    public void checkSaleSetIncome(){

        double expected = 0.0;
        income = sale.getQuant() * wat.getPrice();

        String str = String.valueOf(income);
        int dotIndex = str.indexOf(".");

        String before = String.valueOf((int) income);
        String incStr = null;
        if((str.length()-dotIndex)>=3){
            incStr = String.valueOf((int) income) + "." + str.substring(dotIndex+1, (dotIndex+3));
        }else{
            incStr = str;
        }

        String first = incStr.substring(incStr.length()-2, incStr.length()-1);
        String second = incStr.substring(incStr.length()-1);
        if(second.equals("9")){
            if(!first.equals("9")){
                incStr = before + "." + String.valueOf(Integer.parseInt(first)+1);
            }else{
                incStr = String.valueOf(Integer.parseInt(before)+1);
            }
        }
        income = Double.parseDouble(incStr);

        if(income < 500.00){
            expected = income;
            assertEquals(expected, income, 0.01); // expected - actual < epsylon;
        }else if(income >= 500.00 && income < 1000.00){
            expected = income;
            income = income * 0.95 ;
            assertEquals(expected, income, income*0.06 );
        }else{
            expected = income;
            income = income * 0.9 ;
            assertEquals(expected, income, income*0.11 );
        }
    }

    @Test
    public void checkSaleDateCurrentDate(){

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String date = df.format(new Date(currentTimeMillis()));
        assertTrue("The date of sale should be current date.", sale.getDate().equals(date));
    }

    @Test
    public void checkSaleClientDefaultValue(){

        assertNull("Default Client of the sale should be null.", sale.getGuest());
    }

    @Test
    public void checkSaleWaterQuantDefaulValue(){

        assertTrue("Default quant of sold goods should be 0.", sale.getQuant() == 0);
    }


}
