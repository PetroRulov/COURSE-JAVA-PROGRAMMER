package lesson8.files.readandwritefiles;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by prulov on 01.07.2016.
 */
public class Demo {

    public static void main(String[] args) throws IOException {

        File dir = new File("D:\\TestFolder\\");

        dir.mkdir();
        String fileName = File.separator + "test.txt";
        File file = new File(dir.getAbsolutePath() + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter writer = new LegacyFileWriter(file);
        ((LegacyFileWriter)writer).write("I love programming", dir.getAbsolutePath() + fileName);

        FileReader reader = new LegacyFileReader(file);
        System.out.println(((LegacyFileReader)reader).read(dir.getAbsolutePath() + fileName)); // return String

        writer = new DefaultFileWriter(file);
        ((DefaultFileWriter)writer).write("Me too", dir.getAbsolutePath() + fileName);

        reader = new DefaultFileReader(file);
        System.out.println(((DefaultFileReader) reader).read(dir.getAbsolutePath() + fileName));


    }

}
