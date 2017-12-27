package permutations.combinatoring;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    public static void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter("D://TEXT_FILES//testCombine.txt", true), true))
        {
            out.write(message);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
