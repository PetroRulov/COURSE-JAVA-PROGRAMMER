package lesson18;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

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

        URL eDV = null;
        URLConnection urlConn = null;
        try {
            eDV = new URL("https://docs.oracle.com/javase/tutorial/");
            urlConn = eDV.openConnection();
        } catch (MalformedURLException e) {
            System.out.println("Please, check the URL:" + e.toString() );
        }catch (IOException e){
            System.out.println("Can’t read from the Internet: " + e.toString() );
        }

        // to receive a reference at URL by URL-object's name
        System.out.println(eDV.getProtocol() + "://"  + eDV.getHost() + eDV.getFile());

        System.out.println(urlConn.getContentEncoding()); // return null if content encoding is not known
        System.out.println(eDV.getPort()); // return -1 if the port is not set

        //PROXY
//        System.setProperty("http.proxyHost", "http://proxy.mycompany.com");
//        System.setProperty("http.proxyPort", "8080");
//
//        Proxy myProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("http://proxy.mycompany.com", 8080));
//        URL url = null;
//        try {
//            url = new URL("http://www.google.com/index.html");
//            urlConn = url.openConnection(myProxy);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }catch (IOException e){
//        System.out.println("Can’t read from the Internet: " + e.toString() );

        try (BufferedReader input = new BufferedReader(new InputStreamReader(
                urlConn.getInputStream(), StandardCharsets.UTF_8), buffer);
             OutputStreamWriter outsw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
             BufferedWriter output = new BufferedWriter(outsw, buffer)

        ){
            String inputLine;
            while ((inputLine = input.readLine()) != null){
                output.write(inputLine);
            }
        }catch (IOException e) {
            System.out.println("Can’t close the streams: "+ e.getMessage());
        }
    }
}

