package lesson8.files.readandwritefiles.fileinterfaces;

import lesson8.files.readandwritefiles.DefaultFileReader;
import lesson8.files.readandwritefiles.DefaultFileWriter;
import lesson8.files.readandwritefiles.LegacyFileReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by prulov on 06.07.2016.
 */
public class Launcher {

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

        java.io.FileWriter writer = new lesson8.files.readandwritefiles.LegacyFileWriter(file);
        ((lesson8.files.readandwritefiles.LegacyFileWriter)writer).write("I love programming", dir.getAbsolutePath() + fileName);

        FileReader reader = new lesson8.files.readandwritefiles.LegacyFileReader(file);
        System.out.println(((LegacyFileReader)reader).read(dir.getAbsolutePath() + fileName)); // return String

        writer = new lesson8.files.readandwritefiles.DefaultFileWriter(file);
        ((DefaultFileWriter)writer).write("Me too", dir.getAbsolutePath() + fileName);

        reader = new lesson8.files.readandwritefiles.DefaultFileReader(file);
        System.out.println(((DefaultFileReader) reader).read(dir.getAbsolutePath() + fileName));


    }

}
