package lesson8.files.readandwritefiles.fileinterfaces;

import java.io.File;
import java.io.IOException;


/**
 * Created by prulov on 06.07.2016.
 */
public class Launcher {

    public static void main(String[] args) throws IOException {

        File dir = new File("D:\\TestFolder\\");
        dir.mkdir();

        String dPath = dir.getAbsolutePath();
        String fileName = File.separator + "test.txt";

        File file = new File(dir.getAbsolutePath() + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter writer = new LegacyFileWriter();
        writer.write("I love programming", dir.getAbsolutePath() + fileName);

        FileReader reader = new LegacyFilesReader();
        System.out.println(reader.read(dPath + fileName));

        writer = new DefaultFileWriter();
        writer.write("Me too", dir.getAbsolutePath() + fileName);

        reader = new DefaultFilesReader();
        System.out.println(reader.read(dPath + fileName));

        writer = new JDKWriter();
        writer.write("Hi fro JDK Writer", dir.getAbsolutePath() + fileName);

        reader = new JDKReader();
        System.out.println(reader.read(dPath + fileName));

    }

}
