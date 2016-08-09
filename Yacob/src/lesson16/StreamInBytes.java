package lesson16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by prulov on 29.07.2016.
 */
public class StreamInBytes {

    public static void main(String[] args) {

        File dir = new File("D:\\TEST\\Yacob");
        dir.mkdir();
        String fileName = "TestTextFile.txt";
        File file = new File(dir.getAbsolutePath() + File.separator  + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream myFile = new FileInputStream(file)) {
            boolean eof = false;
            while (!eof) {
                int byteValue = myFile.read();
                System.out.print(byteValue + " ");
                if (byteValue == -1) {
                    eof = true;
                }
            }
        }catch (IOException e) {
            System.out.println("Could not read file: " + e.toString());
        }

    }
}

