package lesson8.files.readandwritefiles;

import java.io.*;

/**
 * Created by prulov on 01.07.2016.
 */
public class LegacyFileReader extends FileReader {

    public LegacyFileReader(File file) throws FileNotFoundException {
        super(file);
    }

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
