package lesson8.files.readandwritefiles;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by prulov on 02.07.2016.
 */
public class CopyFileDemo {

    private static final File dir = new File("D:\\CopyFile\\");
    private static final String fileName = File.separator + "Lorem.txt";

    public static void main(String[] args) throws IOException {

        File original = new File(dir.getAbsolutePath() + fileName);
        copyFile(original);
    }

    private static void copyFile(File file) throws IOException {

        String copyFileName = File.separator + "CopyLorem.txt";
        File copy = new File(dir.getAbsolutePath() + copyFileName);

        try {
            copy.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader reader = new LegacyFileReader(file);
        FileWriter writer = new LegacyFileWriter(copy);
        ((LegacyFileWriter)writer).write(((LegacyFileReader)reader).read(dir.getAbsolutePath() + fileName) + " @Copy",
                dir.getAbsolutePath() + copyFileName);
    }
}
