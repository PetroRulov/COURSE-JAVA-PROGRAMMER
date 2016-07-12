package lesson8.encoding;

import lesson8.files.readandwritefiles.fileinterfaces.FileWriter;
import lesson8.files.readandwritefiles.fileinterfaces.JDKWriter;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by prulov on 12.07.2016.
 */
public class ECLaunch {

    public static void main(String[] args) {

        File dir = new File("D:\\TestFolder\\");
        dir.mkdir();

        String dPath = dir.getAbsolutePath();
        String fileName = File.separator + "test.txt";

        File file = new File(dPath + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter writer = new JDKWriter();
        writer.write("Hi fro JDK Writer", dir.getAbsolutePath() + fileName);

        String currentEncoding = "UTF-8";
        //String neededEncoding = "UTF-16";
        //String neededEncoding = "UTF_16BE";
        //String neededEncoding = "UTF_16LE";
        String neededEncoding = "UTF_32";

        changeEncoding(file, currentEncoding, neededEncoding );
    }

    static void changeEncoding(File file, String currentEncoding, String neededEncoding){

        Charset utf8charset = Charset.forName(currentEncoding);
        Charset utf16charset = Charset.forName(neededEncoding);
        String fileName = file.getParent() + File.separator + file.getName();

        StringBuilder builder = new StringBuilder();

        try(
                FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader reader = new InputStreamReader(fis, utf8charset);
                BufferedReader bufferedReader = new BufferedReader(reader);
        ){
            String str;
            while((str = bufferedReader.readLine()) != null){
                builder.append(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, utf16charset);
        ){
            outputStreamWriter.write("Hi fro JDK Writer");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
