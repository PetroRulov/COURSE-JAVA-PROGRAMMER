package lesson8.files;

import java.io.File;
import java.io.IOException;

/**
 * Created by prulov on 30.06.2016.
 */
public class CreateTextFile {

    public static void main(String[] args) throws IOException {

        File f = new File("D:\\TestFolder\\");
        f.mkdir();
        File f1 = new File(f.getAbsolutePath() + "\\test.txt");
        f1.createNewFile();
    }
}
