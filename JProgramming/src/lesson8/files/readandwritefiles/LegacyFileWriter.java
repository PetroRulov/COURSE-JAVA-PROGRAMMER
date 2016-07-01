package lesson8.files.readandwritefiles;

import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by prulov on 01.07.2016.
 */
public class LegacyFileWriter extends FileWriter {

    private String fileName;

    public LegacyFileWriter(String fileName) throws IOException {
        super(String.valueOf(new FileOutputStream(fileName)));
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
