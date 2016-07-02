package lesson8.files.readandwritefiles;

import java.io.*;

/**
 * Created by prulov on 01.07.2016.
 */
public class DefaultFileReader extends FileReader {

    public DefaultFileReader(File file) throws FileNotFoundException {
        super(file);
    }

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
