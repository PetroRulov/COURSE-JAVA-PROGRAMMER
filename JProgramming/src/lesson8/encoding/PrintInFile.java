package lesson8.encoding;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Created by prulov on 12.07.2016.
 */
public class PrintInFile {

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

        writeFromOutToFile(file);

        // just to check
        Path path = FileSystems.getDefault().getPath("D:\\TestFolder\\test.txt");
        InputStream in = null;
        try {
            in = Files.newInputStream(path, StandardOpenOption.READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printStreamData(in);

    }

    private static void writeFromOutToFile(File file) {

        Scanner scan = new Scanner (System.in);
        System.out.println("Input the word or frase, please:");
        String lineFromInput = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            lineFromInput = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileName = file.getParent() + File.separator + file.getName();

        try(
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        ){
            outputStreamWriter.write(lineFromInput);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // just to check previous method
    private static void printStreamData(InputStream in) {

        StringBuilder builder = new StringBuilder();
        int i = 0;
        try {
            while ((i = in.read()) != -1)
                builder.append((char) i);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());
    }

}
