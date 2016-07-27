package lesson8.archivation;

import java.io.File;
import java.io.IOException;

/**
 * Created by prulov on 26.07.2016.
 */
public class Launcher {

    public static void main(String[] args) {

        File dir = new File("D:\\TEST\\Zip");
        dir.mkdir();

        String fileName = File.separator + "Stock.txt";
        File original = new File(dir.getAbsolutePath() + fileName);

        System.out.println(original.getAbsolutePath());
        System.out.println(original.getParent());

        new Zip(original.getAbsolutePath(), original.getParent());
        original.delete();

        String zipedFileName = dir.getAbsolutePath() + File.separator + "Stock.txt.zip";

        File file = new File(dir.getAbsolutePath() + File.separator  + "Stock.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        new UnZip(zipedFileName, file);


    }
}
