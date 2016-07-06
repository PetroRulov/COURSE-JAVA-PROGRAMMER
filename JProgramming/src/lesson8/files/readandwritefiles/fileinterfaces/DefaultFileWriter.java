package lesson8.files.readandwritefiles.fileinterfaces;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by prulov on 06.07.2016.
 */
public class DefaultFileWriter implements FileWriter {

    @Override
    public void write(String data, String fileName) {

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
