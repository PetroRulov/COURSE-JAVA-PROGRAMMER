package lesson8.files.printdata;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Created by prulov on 02.07.2016.
 */
public class PrintData {

    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("D:\\TEST\\CopyFile\\Lorem.txt");

        File file = new File("D:\\TEST\\CopyFile\\Stock.txt");

        Path path1 = file.toPath();

        InputStream in = null;

        try {
            in = Files.newInputStream(path, StandardOpenOption.READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

        printStreamData(in);
        System.out.println();

        try {
            printStreamData(Files.newInputStream(path1, StandardOpenOption.READ));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

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
