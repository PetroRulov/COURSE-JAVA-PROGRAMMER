package lesson8.archivation;

import java.io.File;

public class Launcher {

    public static void main(String[] args) {
        File dir = new File("D:\\CopyFile\\");
        dir.mkdir();

        String fileName = File.separator + "Stock.txt";
        File original = new File(dir.getAbsolutePath() + fileName);

        new Zip(original.getAbsolutePath(), original.getParent());

        new UnZip(original.getAbsolutePath());

    }
}

