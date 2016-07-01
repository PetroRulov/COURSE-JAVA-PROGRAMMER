package lesson8.files.readandwritefiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by prulov on 01.07.2016.
 */
public class Demo {

    public static void main(String[] args) throws IOException {

        File dir = new File("D:\\TestFolder\\");
        dir.mkdir();
        String fileName = "\\test.txt";
        File file = new File(dir.getAbsolutePath() + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter writer = new LegacyFileWriter(fileName);
        ((LegacyFileWriter)writer).write("I love programming", fileName);

    }

}
