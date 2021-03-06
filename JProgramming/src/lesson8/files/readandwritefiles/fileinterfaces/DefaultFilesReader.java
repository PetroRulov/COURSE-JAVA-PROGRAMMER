package lesson8.files.readandwritefiles.fileinterfaces;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by prulov on 06.07.2016.
 */
public class DefaultFilesReader implements FileReader {

    @Override
    public String read(String fileName){

        StringBuilder builder = new StringBuilder();

        try(FileInputStream fis = new FileInputStream(fileName)){

            int i;
            while((i = fis.read()) != -1){
                builder.append((char) i);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }
}
