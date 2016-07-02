package lesson8.files.readandwritefiles;

import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by prulov on 01.07.2016.
 */
public class LegacyFileWriter extends FileWriter {


    public LegacyFileWriter(File file) throws IOException {
        super(file);
    }

    public void write(String data, String fileName){

        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream(fileName);
            fos.write(data.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(fos != null){
                try{
                    fos.close();
                }catch(IOException e){
                    // ignore
                }
            }
        }
    }
}
