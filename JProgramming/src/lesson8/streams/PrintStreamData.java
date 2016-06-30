package lesson8.streams;

import java.io.ByteArrayInputStream;

/**
 * Created by prulov on 30.06.2016.
 */
public class PrintStreamData {

    public static void main(String[] args) {


        byte bytes[] = {4, -5, 9, 127, -128, 45, 54, -63, -64, 65, 18};

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        printStreamData(in);

        System.out.println();
    }

    public static void printStreamData(ByteArrayInputStream bAIS){

        int i;
        System.out.print("[");
        while((i = bAIS.read()) != -1){
            System.out.print((byte) i);
            System.out.print(" ");
        }
        System.out.print("]");
    }
}
