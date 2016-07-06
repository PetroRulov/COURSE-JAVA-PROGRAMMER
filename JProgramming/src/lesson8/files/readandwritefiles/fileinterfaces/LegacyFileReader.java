package lesson8.files.readandwritefiles.fileinterfaces;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by prulov on 06.07.2016.
 */
public class LegacyFileReader implements FileReader {

    @Override
    public String read(String fileName){

        StringBuilder builder = new StringBuilder();
        FileInputStream fis = null;

        try{
            fis = new FileInputStream(fileName);
            int i;
            while((i = fis.read()) != -1){
                builder.append((char) i);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fis != null){
                try{
                    fis.close();
                }catch(IOException e){
                    // ignore
                }
            }

        }
        return builder.toString();
    }
}
