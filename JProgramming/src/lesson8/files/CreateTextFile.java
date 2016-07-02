package lesson8.files;

import java.io.File;
import java.io.IOException;

/**
 * Created by prulov on 30.06.2016.
 */
public class CreateTextFile {

    public static void main(String[] args) throws IOException {

        File dir = new File("D:\\TestFolder");
        dir.mkdir();
        File file = new File(dir.getAbsolutePath() + File.separator  + "test.txt");
        file.createNewFile();
    }
}
