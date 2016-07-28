package lesson8.serialization.urlconn;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Created by prulov on 27.07.2016.
 */
public class UploadFromInternet {

    public static void main(String[] args) {

        int buffer = 1024;
        String path = "D:\\TEST\\URLConn\\";
        String fileName = "edv.html";

        File file = new File(path + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getAbsolutePath());

        URL eDV = null;
        URLConnection urlConn = null;
        try {
            eDV = new URL("https://docs.oracle.com/javase/tutorial/");
            urlConn = eDV.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(urlConn.getContentEncoding()); // return null if content encoding is not known

        try (BufferedReader input = new BufferedReader(new InputStreamReader(
                urlConn.getInputStream(), StandardCharsets.UTF_8), buffer);
             OutputStreamWriter outsw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
             BufferedWriter output = new BufferedWriter(outsw, buffer)

        ){
            String inputLine;
            while ((inputLine = input.readLine()) != null){
                output.write(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
