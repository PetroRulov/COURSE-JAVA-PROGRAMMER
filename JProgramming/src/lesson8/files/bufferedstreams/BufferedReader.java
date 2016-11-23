package lesson8.files.bufferedstreams;

import java.io.*;

public class BufferedReader extends FileReader {

    public BufferedReader(File file) throws FileNotFoundException {
        super(file);
    }

    public String read(String fileName){

        StringBuilder builder = new StringBuilder();

        try(FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
                ) {
            int i;
            while((i = bis.read()) != -1){

                builder.append((char) i);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }
}
