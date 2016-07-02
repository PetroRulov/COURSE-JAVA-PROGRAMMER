package lesson8.files.readandwritefiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by prulov on 01.07.2016.
 */
public class DefaultFileWriter extends FileWriter {

    public DefaultFileWriter(File file) throws IOException {
        super(file);
    }

    public void write(String data, String fileName) {

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
