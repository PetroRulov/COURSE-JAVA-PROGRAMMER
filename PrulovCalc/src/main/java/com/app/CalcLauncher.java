package com.app;

/**
 * Created by prulov on 21.09.2016.
 */
public class CalcLauncher {

    public static void main(String[] args) throws Exception{

        Calculation c = new Calculation();
        new CalcGUI(c);
    }
}
