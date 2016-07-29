package lesson8.zconsolidation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by prulov on 29.07.2016.
 */
public class StreamInBytes {

    public static void main(String[] args) {

        FileInputStream myFile = null;
        try {
            myFile = new FileInputStream(System.getProperty("user.dir") + File.separator + "outputObject.dat");
            boolean eof = false;
            while (!eof) {
                int byteValue = myFile.read();
                System.out.print(byteValue + " ");
                if (byteValue == -1) {
                    eof = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.toString());
        } finally {
            if (myFile != null) {
                try {
                    myFile.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
