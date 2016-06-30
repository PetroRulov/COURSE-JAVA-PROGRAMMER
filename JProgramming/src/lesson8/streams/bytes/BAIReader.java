package lesson8.streams.bytes;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by prulov on 30.06.2016.
 */
public class BAIReader {

    public static void main(String[] args) {

        byte bytes[] = {4, -5, 9, 127, -128, 45, 54, -63, -64, 65, 18};

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        int i;
        while((i = in.read()) != -1){
            System.out.print((byte) i);
            System.out.print(" ");
        }

        System.out.println();

        try {
            System.out.println("read(bytes) return " + in.read(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        i = 0;
        while((i = in.read()) != -1){
            System.out.println("read(bytes, 3, 4) return " + in.read(bytes, 3, 4));
            System.out.print(" ");
        }

        System.out.println("read(bytes, 3, 4) return " + in.read(bytes, 3, 4));
    }
}
