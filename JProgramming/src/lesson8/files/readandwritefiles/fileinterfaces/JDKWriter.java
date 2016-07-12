package lesson8.files.readandwritefiles.fileinterfaces;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Created by prulov on 12.07.2016.
 */
public class JDKWriter implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        try(
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, StandardCharsets.ISO_8859_1);
        ){
            outputStreamWriter.write(data);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
